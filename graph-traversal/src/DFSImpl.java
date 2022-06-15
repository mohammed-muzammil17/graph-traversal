/*
 * Copyright (c) 2022 Uniphi Inc
 * All rights reserved.
 *
 * File Name: BFSImpl.java
 *
 * Created On: 2022-06-07
 */


import java.util.List;
import java.util.Stack;

public class DFSImpl implements Graph
{

@Override
public void init(Node node)
{
    setCurrentNode(node);
    StackNodeFrame.nodeStack.push(null);
    doPreorderTraversal(node);
}

public void doPreorderTraversal(Node node)
{
    node.printNode();
    List<Node> listAllChild = node.getChildList();
    if (listAllChild != null)
    {
        for (int j = 0; j < listAllChild.size(); j++)
        {
            Node nodeCurr = listAllChild.get(j);
            doPreorderTraversal(nodeCurr);
        }
    }
}

@Override
public Node getNextNode()
{
    List<Node> childList = getCurrentNode().getChildList();

    if (childList.isEmpty())
    {
        StackNodeFrame.nodeVisited.put(getCurrentNode(),true);
        return StackNodeFrame.nodeStack.pop();
    }

    for (Node childNode:childList)
    {
        StackNodeFrame.nodeStack.push(childNode);
    }

    for (int i = 0; i < childList.size(); i++)
    {
        if (StackNodeFrame.nodeVisited.get(childList.get(i)) == null)
        {
            StackNodeFrame.nodeVisited.put(childList.get(i), true);
            Node nextNode = StackNodeFrame.nodeStack.pop();
            setCurrentNode(nextNode);
            return nextNode;
        }
        else
        {
            Node nextNode = StackNodeFrame.nodeStack.pop();
            setCurrentNode(nextNode);
            return nextNode;
        }
    }
    return null;
}

@Override
public Node getCurrentNode()
{
    return null;
}

@Override
public void setCurrentNode(Node node)
{
    //
}

} ///////// End of class
