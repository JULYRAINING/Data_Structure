package dataStructure.linearList.test;

import dataStructure.linearList.SeqStack;

public class Exp_bracket {
	
	public static String isValid(String expstr){
		SeqStack<String>stack = new SeqStack<String>(expstr.length());
		int i = 0;
		while(i<expstr.length()){
			
			char ch = expstr.charAt(i);
			i++;
			switch(ch){
			case '(':	stack.push(ch+"");
				break;
			case ')':if(stack.isEmpty()||!stack.pop().equals("(")){
				return "期望(";
				}
			}
		
		}
		if(stack.isEmpty()){
			return "";
		}else{
			return "期望)";
		}
	}
	
	public static void main(String[] args) {
		String expstr = "((1+2)*3+4)";
		System.out.println(expstr + " " + isValid(expstr));
	}
}
