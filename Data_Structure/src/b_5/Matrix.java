package b_5;

import java.util.Collections;

/**
 * 矩阵
 * @author TF
 *
 */
public class Matrix implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Matrix)super.clone();
	}
	private int value[][];
	
	public Matrix(int m, int n){
		this.value = new int[m][n];
	}
	public Matrix(int n){
		this(n, n);
	}
	public Matrix(){
		this(10,10);
	}
	public Matrix(int mat[][]){
		this(mat.length, mat[0].length);
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[i].length; j++){
				this.value[i][j] = mat[i][j];
			}
		}
	}
	
	public int get(int i, int j){
		return value[i][j];
	}
	public void set(int i, int j, int k){
		value[i][j] = k;
	}
	/**
	 * 矩阵相加
	 * @param b
	 */
	public void add(Matrix b){
		
		for(int i = 0; i < this.value.length; i++){
			for(int j = 0; j<this.value[i].length; j ++){
				this.value[i][j] += b.value[i][j];
			}
		}
	}
	/**
	 * 矩阵相减
	 * @param b
	 */
	public void subtract(Matrix b){
		for(int i = 0; i < this.value.length; i++){
			for(int j = 0; j<this.value[i].length; j ++){
				this.value[i][j] -= b.value[i][j];
			}
		}
	}
	/**
	 * 矩阵转置
	 * @return
	 * @throws Exception
	 */
	public Matrix transfer() throws Exception{
		if(this.value.length != this.value[0].length){
			throw new Exception("行数与列数不相等， 无法转置矩阵。");
		}
		Matrix temp = new Matrix(this.value.length, this.value[0].length);
//		Matrix temp = (Matrix) this.clone();
		System.out.println(temp == this);
		for(int i = 0; i < this.value.length; i++){
			for(int j = 0; j<this.value[i].length; j ++){
				temp.value[i][j] = this.value[j][i];
			}
		}
		return temp;
	}
	/**
	 * 矩阵相乘
	 * @param b
	 * @return 
	 */
	public Matrix multiply(Matrix b){
		Matrix temp = new Matrix(this.value.length, b.value[0].length);
		for(int i = 0; i < this.value.length; i++){
			
			for(int j = 0; j<b.value[0].length; j ++){
				int sum = 0;
				for(int x = 0; x < b.value.length; x++){
					sum += this.value[i][x] * b.value[x][j];
				}
				temp.value[i][j] = sum;
			}
			System.out.println("calculate:" + i);
		}
		return temp;
	}
	public String toString(){
		String str = "";
		for(int i = 0; i < this.value.length; i++){
			for(int j = 0; j <this.value[i].length; j++){
				str += " " + value[i][j];
			}
			str += "\n";
		}
		return str;
	}
	
}
