package interview;

import java.util.Set;
import java.util.TreeSet;

public class Sets {

    public static void main(String[] args) {

        Set<User> userSet = new TreeSet<>();
//        Set<User> userSet = new HashSet<>();

        User userOne = new User("1", "1");
//        User userTwo = new User("1", "1");
        User userTwo = new User("2", "2");

        userSet.add(userOne);
        userSet.add(userTwo);

        System.out.println(userSet);

        userOne.setFirstName(userTwo.getFirstName());
        userOne.setLastName(userTwo.getLastName());

        System.out.println(userSet);

    }


    public static class User implements Comparable<User> {
        private String firstName;
        private String lastName;

        public User(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }

        @Override
        public int compareTo(User o) {
            int i = getFirstName().compareTo(o.getFirstName());
            if (i != 0) {
                return i;
            }
            return getLastName().compareTo(o.getLastName());
        }
    }
}