package _test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Enum {
    public static void main(String[] args){
        String name = "사과";
        Role role = Role.valueOfName(name);
        System.out.println(name);
        System.out.println(role);
        System.out.println(Role.BY_NAME);
    }

    public enum Role{
        APPLE("사과"), BANANA("바나나");
        final private String name;
        public String getName() {
            return name;
        }
	    Role(String name){
            this.name = name;
        }

        private static final Map<String, Role> BY_NAME =
                Stream.of(values()).collect(Collectors.toMap(Role::getName, Function.identity()));

        public static Role valueOfName(String name) {
            return BY_NAME.get(name);
        }
    }
}
