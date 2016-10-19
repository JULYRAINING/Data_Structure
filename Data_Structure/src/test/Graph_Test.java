package test;

import org.junit.Test;

import dataStructure.graph.AdjListGraph;
import dataStructure.graph.AdjMatrixGraph;
import dataStructure.graph.Edge;

public class Graph_Test {
	
	@Test
	public void test_weight_undirect_graph(){
		String[] vertices = {"A", "B", "C", "D", "E"};
		Edge[] edges = {new Edge(0, 1, 5), new Edge(0, 3, 2),
				new Edge(1, 0, 5), new Edge(1, 2, 7), new Edge(1, 3, 6),
				new Edge(2, 1, 7), new Edge(2, 3, 8), new Edge(2, 4, 3),
				new Edge(3, 0, 2), new Edge(3, 1, 6), new Edge(3, 2, 8),
				new Edge(3, 4, 9), new Edge(4, 2, 3), new Edge(4, 3, 9),
		};
		
		AdjMatrixGraph<String>graph = new AdjMatrixGraph<>(vertices, edges);
		
//		System.out.println("��Ȩ����ͼG3��"+graph.toString());
		
//		System.out.println("����v2���ڽӶ���Ϊ"+graph.getFirstNeighbor(2));
		
//		System.out.println("����v2��v2֮�����һ���ڽӶ���Ϊ"+graph.getNextNeighbor(2, 3));
		
//		System.out.println("ɾ������v2:"+graph.removeVertex(2)+"");
		
//		System.out.println("ɾ����(v2, v3), "+ (graph.removeEdge(2, 3)&&graph.removeEdge(3, 2)));
		
//		System.out.println(graph.toString());
		
		System.out.println("���붥��F:"+graph.insertVertex("F")+"");
		System.out.println("���붥��G:"+graph.insertVertex("G")+"");
		
		System.out.println("����ߣ�"+graph.insertEdge(new Edge(0, 5, 21)));
		
		System.out.println(graph.toString());
		
		System.out.println("�����㣺"+ graph.hasIsoland().toString());
		
//		System.out.println("ɾ������F:"+graph.removeVertex(4)+"");
		
		System.out.println("ɾ����:"+graph.removeEdge(0, 5)+"");
		
		System.out.println(graph.toString());
		
		System.out.println("�����㣺"+ graph.hasIsoland().toString());
		
	}
	@Test
	public void test_weight_directed_graph(){
		String[] vertices = {"A", "B", "C", "D", "E"};
		Edge[] edges = {new Edge(0, 1, 5),new Edge(0, 3, 2),
				new Edge(1, 0, 6),new Edge(1, 2, 7),
				new Edge(2, 4, 3),new Edge(3, 2, 8),
				new Edge(3, 4, 9)};
		
		AdjListGraph<String>graph = new AdjListGraph<>(vertices, edges);
		System.out.println("��Ȩ����ͼG4��"+graph.toString());
		System.out.println("ɾ������v2��"+graph.removeVertex(2)+"");
		System.out.println("ɾ����(v2,v3),"+graph.removeEdge(2, 3)+"");
		System.out.println("��Ȩ����ͼG4�� "+graph.toString());
	}
	@Test
	public void test_traverse(){
		String[] vertices = {"A", "B", "C", "D", "E"};
		Edge[] edges = {new Edge(0, 1, 5),new Edge(0, 3, 2),
				new Edge(1, 0, 6),new Edge(1, 2, 7),
				new Edge(2, 4, 3),new Edge(3, 2, 8),
				new Edge(3, 4, 9)};
		
		AdjListGraph<String>graph = new AdjListGraph<>(vertices, edges);
		System.out.println("������ȱ������Ϊ��\n");
		for(int i = 0; i<graph.vertexCount(); i++){
			
			graph.DFSTraverse(i);
			
		}
		System.out.println("������ȱ������Ϊ��\n");
		for(int i = 0; i<graph.vertexCount(); i++){
			
			graph.BFSTraverse(i);
			
		}
	}
}
