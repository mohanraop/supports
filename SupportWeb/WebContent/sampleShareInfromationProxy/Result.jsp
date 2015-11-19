<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleShareInfromationProxyid" scope="session" class="com.train.ws.service.ShareInfromationProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleShareInfromationProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleShareInfromationProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleShareInfromationProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.train.ws.service.ShareInfromation getShareInfromation10mtemp = sampleShareInfromationProxyid.getShareInfromation();
if(getShareInfromation10mtemp == null){
%>
<%=getShareInfromation10mtemp %>
<%
}else{
        if(getShareInfromation10mtemp!= null){
        String tempreturnp11 = getShareInfromation10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String shareName_1id=  request.getParameter("shareName16");
            java.lang.String shareName_1idTemp = null;
        if(!shareName_1id.equals("")){
         shareName_1idTemp  = shareName_1id;
        }
        String sharePrice_2id=  request.getParameter("sharePrice18");
        int sharePrice_2idTemp  = Integer.parseInt(sharePrice_2id);
        sampleShareInfromationProxyid.insertShare(shareName_1idTemp,sharePrice_2idTemp);
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>