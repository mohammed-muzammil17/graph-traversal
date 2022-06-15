/*
 * Copyright (c) 2022 Uniphi Inc
 * All rights reserved.
 *
 * File Name: Graph.java
 *
 * Created On: 2022-06-07
 */


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public interface Graph
{

void init(Node node);

Node getCurrentNode();

void setCurrentNode(Node node);

void doPreorderTraversal(Node node);

Node getNextNode();

interface Node
{
    void printNode();

    List<Node> getChildList();
}

class StackNodeFrame{
    static Stack<Node> nodeStack = new Stack<>();
    static Map<Node, Boolean> nodeVisited = new HashMap<>();
}

} ///////// End of interface
