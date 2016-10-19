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
		
//		System.out.println("带权无向图G3："+graph.toString());
		
//		System.out.println("顶点v2的邻接顶点为"+graph.getFirstNeighbor(2));
		
//		System.out.println("顶点v2在v2之后的下一个邻接顶点为"+graph.getNextNeighbor(2, 3));
		
//		System.out.println("删除顶点v2:"+graph.removeVertex(2)+"");
		
//		System.out.println("删除边(v2, v3), "+ (graph.removeEdge(2, 3)&&graph.removeEdge(3, 2)));
		
//		System.out.println(graph.toString());
		
		System.out.println("插入顶点F:"+graph.insertVertex("F")+"");
		System.out.println("插入顶点G:"+graph.insertVertex("G")+"");
		
		System.out.println("插入边："+graph.insertEdge(new Edge(0, 5, 21)));
		
		System.out.println(graph.toString());
		
		System.out.println("孤立点："+ graph.hasIsoland().toString());
		
//		System.out.println("删除顶点F:"+graph.removeVertex(4)+"");
		
		System.out.println("删除边:"+graph.removeEdge(0, 5)+"");
		
		System.out.println(graph.toString());
		
		System.out.println("孤立点："+ graph.hasIsoland().toString());
		
	}
	@Test
	public void test_weight_directed_graph(){
		String[] vertices = {"A", "B", "C", "D", "E"};
		Edge[] edges = {new Edge(0, 1, 5),new Edge(0, 3, 2),
				new Edge(1, 0, 6),new Edge(1, 2, 7),
				new Edge(2, 4, 3),new Edge(3, 2, 8),
				new Edge(3, 4, 9)};
		
		AdjListGraph<String>graph = new AdjListGraph<>(vertices, edges);
		System.out.println("带权有向图G4，"+graph.toString());
		System.out.println("删除顶点v2："+graph.removeVertex(2)+"");
		System.out.println("删除边(v2,v3),"+graph.removeEdge(2, 3)+"");
		System.out.println("带权有向图G4， "+graph.toString());
	}
	@Test
	public void test_traverse(){
		String[] vertices = {"A", "B", "C", "D", "E"};
		Edge[] edges = {new Edge(0, 1, 5),new Edge(0, 3, 2),
				new Edge(1, 0, 6),new Edge(1, 2, 7),
				new Edge(2, 4, 3),new Edge(3, 2, 8),
				new Edge(3, 4, 9)};
		
		AdjListGraph<String>graph = new AdjListGraph<>(vertices, edges);
		System.out.println("深度优先遍历结果为：\n");
		for(int i = 0; i<graph.vertexCount(); i++){
			
			graph.DFSTraverse(i);
			
		}
		System.out.println("广度优先遍历结果为：\n");
		for(int i = 0; i<graph.vertexCount(); i++){
			
			graph.BFSTraverse(i);
			
		}
	}
}
