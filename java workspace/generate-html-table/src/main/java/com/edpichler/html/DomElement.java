package com.edpichler.html;

import java.util.ArrayList;
import java.util.List;

/**
 * Any DOM element. E.g.: html, body, etc.
 */
public class DomElement {

    private final String tag;
    private List<DomElement> childs = new ArrayList<DomElement>();

    private String cssStyle;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    /**
     *
     * @param tag any tag. E.g.: body, div, td, tr, etc.
     */
    public DomElement(String tag) {
        this.tag = tag;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("<");
        sb.append(tag);
        if(cssStyle != null && cssStyle.length() > 0){
            sb.append(" style=\"");
            sb.append(cssStyle);
            sb.append("\"");
        }
        sb.append(">");
//        sb.append("\n");

        if(this.childs.size() > 0) {
            for (DomElement child : childs) {
                sb.append(child.toString());
            }
        }else {
            sb.append(this.content);
        }

        sb.append("</");
        sb.append(tag);
        sb.append(">");
        return sb.toString();
    }

    public void addChild(DomElement child){
        this.childs.add(child);
    }
    public DomElement addChild(String tag){
        DomElement e = new DomElement(tag);
        this.childs.add(e);
        return e;
    }

    public static void main(String[] args) {
        DomElement html = new DomElement("html");
        DomElement body = new DomElement("body");
        DomElement div = body.addChild("div");
        div.setCssStyle("text-align:center;");
        div.setContent("Content!");
        html.addChild(body);

        System.out.println(html);
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }
}
