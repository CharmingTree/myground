package com.oaktree.practice2;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import structure.tree.binarytree.avl.AVLTree;
import structure.tree.binarytree.avl.Demo;


@SpringBootApplication
@Slf4j
public class Practice2Application {

	public static void main(String[] args) {

		SpringApplication.run(Practice2Application.class, args);

		Demo.run();


	}

}
