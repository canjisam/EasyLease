public class test {
    public static void main(String[] args) {
        int i = 3;

        while (i <= 100) {
            String s2 = "INSERT INTO `system_user` VALUES ("
                    + i + ", 'user" + i
                    + "', 'e10adc3949ba59abbe56e057f20f883e', '用户', 1, '13666666666', NULL, NULL, 7, 1, '2023-08-19 16:53:53', NULL, 0);";
//            String s2 = "INSERT INTO `user_info` VALUES (" +
//                    i + ", '13888888888', NULL, NULL, '用户-888888" +
//                    i + "', " +
//                    "2, '2023-07-01 14:48:17', NULL, 0);";
            System.out.println(s2);
            i += 1;

        }
    }
}
