package dataStructure.linearList.test;

import dataStructure.linearList.SeqStack;

public class Expression {
	
	public static String toPostfix(String expstr){
		
		SeqStack<String>stack = new SeqStack<String>(expstr.length());
		String postfix = "";
		int i = 0;
		while(i < expstr.length()){
			char ch = expstr.charAt(i);
			switch(ch){
				case '+':
				case '-':
					while(!stack.isEmpty()&&!stack.get().equals(")")){
						postfix += stack.pop();
					}
					stack.push(ch + "");
					i++;
					break;
				case '*':
				case '/':
					while(!stack.isEmpty()&&
							(stack.get().equals("*")
									||stack.get().equals("/"))){
						postfix += stack.pop();
					}
					stack.push(ch + "");
					i++;
					break;
				case '(':
					stack.push(ch + "");
					i++;
					break;
				case ')':
					String out = stack.pop();
					while(out!=null&&!out.equals("(")){
						postfix += out;
						out = stack.pop();
					}
					i++;
					break;
				default:
					while(ch >= '0' &&ch <= '9'){
						postfix += ch;
						i++;
						if(i < expstr.length()){
							ch = expstr.charAt(i);
						}else{
							ch = '=';
						}
					}
					postfix += "";
			}
			
		}
		
		
		while(!stack.isEmpty()){
			postfix += stack.pop();
		}
		
		
		
		return postfix;
	}
	
	
	public static void main(String[] args) {
		String exp = "1+2*(3-4)+5";
		
		String postfix = toPostfix(exp);
		
		System.out.println(postfix);
	}
}
