import {
  createRouter,
  createWebHashHistory,
  type RouteLocationNormalized
} from "vue-router";
import routes from "./routes";
import { useCachedViewStoreHook } from "@/store/modules/cachedView";
import NProgress from "@/utils/progress";
import setPageTitle from "@/utils/set-page-title";
import { getToken } from "@/utils/token"; // Added import

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

export interface toRouteType extends RouteLocationNormalized {
  meta: {
    title?: string;
    noCache?: boolean;
    requiresAuth?: boolean; // Added optional meta field for auth check
  };
}

router.beforeEach((to: toRouteType, from, next) => {
  NProgress.start();

  const token = getToken();

  // Authentication check: All pages except Login require authentication
  if (to.name !== 'Login' && !token) {
    // If route requires auth and user is not logged in, redirect to login
    next({ name: "Login", query: { redirect: to.fullPath, showLoginPrompt: 'true' } }); // Redirect to Login route, pass original destination and prompt flag
    NProgress.done(); // Ensure progress bar stops on redirect
    return; // Stop further execution in this guard
  }

  // 解决路由缓存导致的 keep-alive 组件不刷新的问题
  if (to.name === "Login") {
    useCachedViewStoreHook().delAllCachedViews();
  }
  // 路由缓存
  useCachedViewStoreHook().addCachedView(to);
  // 页面 title
  setPageTitle(to.meta.title);
  next();
});

router.afterEach(() => {
  NProgress.done();
});

export default router;
