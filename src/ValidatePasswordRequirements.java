
public class ValidatePasswordRequirements {

        public static void checkCharacters(char character, int[] category) {
                if (Character.isAlphabetic(character)) {
                        if (character == Character.toLowerCase(character)) {
                                category[0]++;
                        } else {
                                category[1]++;
                        }
                } else if (Character.isDigit(character)) {
                        category[2]++;
                } else if ("~!@#$%^&*()-=+_".indexOf(character) != -1) {
                        category[3]++;
                }

        }

        public static int getPasswordScore(String password) {
                int score = 0;
                int category[] = new int[4]; // Categories as follows: index 0 = lower case, 1 = upper case,
                                             // 2 = numbers, 3 = special characters
                for (int i = 0; i < password.length(); i++) {
                        checkCharacters(password.charAt(i), category);
                }
                if (category[0] + category[1] + category[2] + category[3] != password.length()) {
                        return -1; // This means that there is a character other than the allowed characters
                }

                if (category[0] > 0) {
                        score += 1;
                }
                if (category[1] > 0) {
                        score += 1;
                }
                if (category[2] > 0) {
                        score += 1;
                }
                if (category[3] > 0) {
                        score += 1;
                }
                return score;
        }

        public static void main(String[] args) throws Exception {
                try {
                        String password = args[0];
                        if ((password.length() > 16) || (password.length() < 8)) {
                                System.out.println("\nThis password is not valid!\n");
                                System.out.println("The password \"" + password + "\" does not have a valid length.");
                                System.out.println("Valid passwords are 8 to 16 characters long. The given password is "
                                                + password.length() + " characters long.");
                        } else {
                                int passwordScore = getPasswordScore(password);
                                if (passwordScore >= 3) {
                                        System.out.println("\nThis password is valid!");
                                } else if (passwordScore == -1) {
                                        System.out.println("\nThis password is not valid!\n");
                                        System.out.println(
                                                        "The password contains an invalid character. Passwords must only contain characters from at least 3 of the following 4 categories: ");
                                        System.out.println(
                                                        "\t1) Lower case letters, (a-z)");
                                        System.out.println(
                                                        "\t2) Upper case letters, (a-z)");
                                        System.out.println(
                                                        "\t3) Numbers, (0-9)");
                                        System.out.println(
                                                        "\t4) The following special characters: ~!@#$%^&*()-=+_");
                                } else {
                                        System.out.println("\nThis password is not valid!\n");
                                        System.out.println("The password includes characters from only " + passwordScore
                                                        + " of the following 4 categories (must satisfy at least 3 categories): ");
                                        System.out.println(
                                                        "\t1) Lower case letters, (a-z)");
                                        System.out.println(
                                                        "\t2) Upper case letters, (a-z)");
                                        System.out.println(
                                                        "\t3) Numbers, (0-9)");
                                        System.out.println(
                                                        "\t4) The following special characters: ~!@#$%^&*()-=+_");
                                }

                        }

                } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(
                                        "\nNo input given! You must input the password that you would like to check. Valid passwords meet the following requirements:");
                        System.err.println(
                                        "1) The password is 8 to 16 characters long.");
                        System.err.println(
                                        "2) The password contains only characters from at least 3 of the following 4 categories: ");
                        System.err.println(
                                        "\ta) Lower case letters, (a-z)");
                        System.err.println(
                                        "\tb) Upper case letters, (a-z)");
                        System.err.println(
                                        "\tc) Numbers, (0-9)");
                        System.err.println(
                                        "\td) The following special characters: ~!@#$%^&*()-=+_");
                        System.err.println();
                        //e.printStackTrace();
                        System.exit(1);
                }

        }
}
