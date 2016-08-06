package com.chelpus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SimpleXPath
{
  public static final String XPATH_SEPARATOR = "/";
  Document mDocument;
  
  public SimpleXPath(File paramFile)
    throws ParserConfigurationException, SAXException, IOException
  {
    this.mDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(paramFile));
  }
  
  private void getNodes(Node paramNode, String paramString, List<XNode> paramList)
  {
    paramString = paramString.split("/", 2);
    int i;
    if (paramString.length == 1)
    {
      i = 1;
      paramNode = paramNode.getFirstChild();
    }
    for (;;)
    {
      if (paramNode == null) {
        return;
      }
      if (paramString[0].equals(paramNode.getNodeName()))
      {
        if (i == 0) {
          break label80;
        }
        paramList.add(new XNode(paramNode));
      }
      for (;;)
      {
        try
        {
          paramNode = paramNode.getNextSibling();
        }
        catch (Exception paramNode)
        {
          label80:
          paramNode = null;
        }
        i = 0;
        break;
        getNodes(paramNode, paramString[1], paramList);
      }
    }
  }
  
  public Node getRoot()
  {
    return this.mDocument;
  }
  
  public XNode getXPathNode(Node paramNode, String paramString)
  {
    Object localObject = null;
    String[] arrayOfString = paramString.split("/", 2);
    int i;
    if (arrayOfString.length == 1)
    {
      i = 1;
      paramNode = paramNode.getFirstChild();
    }
    for (;;)
    {
      paramString = (String)localObject;
      if (paramNode != null)
      {
        if (!arrayOfString[0].equals(paramNode.getNodeName())) {
          break label82;
        }
        if (i != 0) {
          paramString = new XNode(paramNode);
        }
      }
      else
      {
        return paramString;
        i = 0;
        break;
      }
      return getXPathNode(paramNode, arrayOfString[1]);
      try
      {
        label82:
        paramNode = paramNode.getNextSibling();
      }
      catch (Exception paramNode)
      {
        paramNode = null;
      }
    }
  }
  
  public List<XNode> getXPathNodes(Node paramNode, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    getNodes(paramNode, paramString, localArrayList);
    return localArrayList;
  }
  
  public class XNode
  {
    Node mNode;
    
    public XNode(Node paramNode)
    {
      this.mNode = paramNode;
    }
    
    String getAttribute(String paramString)
      throws XNodeException
    {
      String str = ((Element)this.mNode).getAttribute(paramString);
      if (str.length() == 0) {
        throw new XNodeException(String.format("Node [%s] has no [%s] attribute!", new Object[] { getName(), paramString }));
      }
      return str;
    }
    
    XNode getChild(String paramString)
      throws XNodeException
    {
      List localList = SimpleXPath.this.getXPathNodes(this.mNode, paramString);
      if (localList.size() == 0) {
        throw new XNodeException(String.format("Node [%s] has no child at path [%s]!", new Object[] { this.mNode.getNodeName(), paramString }));
      }
      return (XNode)localList.get(0);
    }
    
    List<XNode> getChildren(String paramString)
      throws XNodeException
    {
      List localList = SimpleXPath.this.getXPathNodes(this.mNode, paramString);
      if (localList.isEmpty()) {
        throw new XNodeException(String.format("Node [%s] has no children at path [%s]!", new Object[] { this.mNode.getNodeName(), paramString }));
      }
      return localList;
    }
    
    float getFloatAttribute(String paramString)
      throws XNodeException
    {
      return Float.parseFloat(getAttribute(paramString));
    }
    
    public int getIntAttribute(String paramString)
      throws XNodeException
    {
      return Integer.parseInt(getAttribute(paramString));
    }
    
    public String getName()
    {
      return this.mNode.getNodeName();
    }
    
    public String getStringAttribute(String paramString)
      throws XNodeException
    {
      return getAttribute(paramString);
    }
    
    public String getValue()
    {
      return this.mNode.getChildNodes().item(0).getNodeValue();
    }
  }
}


/* Location:              /Users/sundayliu/Desktop/gamecheat/com.android.vending.billing.InAppBillingService.LACK-1/classes-dex2jar.jar!/com/chelpus/SimpleXPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */