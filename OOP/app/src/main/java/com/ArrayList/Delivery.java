package com.ArrayList;

import java.util.ArrayList;

public class Delivery {

  public static void main(String[] args) {

    ArrayList<String> packages = new ArrayList<>();

    packages.add("PKG101");

    packages.add("PKG102");

    packages.add("PKG103");

    packages.add("PKG104");

    packages.add("PKG105");

    packages.add(2, "PKG106");

    packages.set(0, "PKG999");

    System.out.println(packages.size());

    System.out.println(packages.contains("PKG103"));

    System.out.println(packages.isEmpty());

    for (String code : packages)

      System.out.println(code);

  }

}
