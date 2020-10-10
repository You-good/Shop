package com.shop.controller;

import com.shop.bean.Goods;
import com.shop.service.GoodsService;
import com.shop.service.impl.GoodsServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class GoodsModifyServlet extends HttpServlet {
    GoodsService goodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if ("one".equals(req.getParameter("action"))){
            System.out.println("第一次");
            Goods goods = goodsService.queryById(Long.valueOf(req.getParameter("goodsId")));
            req.setAttribute("goods",goods);
            req.setAttribute("goodsId",req.getParameter("goodsId"));
            req.setAttribute("pageNum",req.getParameter("pageNum"));
            req.getRequestDispatcher("pages/manager/shop_edit.jsp?operate=modify").forward(req,resp);
        }
        if ("two".equals(req.getParameter("action"))){
            //判断是否属于多段数据类型。多段数据类型才是文件上传
            if (ServletFileUpload.isMultipartContent(req)){
                //创建FileItemFactory工厂实现类
                FileItemFactory fileItemFactory = new DiskFileItemFactory();
                //创建用于解析上传数据的工具类servLetFileUpload类
                ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
                try {
                    //解析上传的数据，得到每一个表单项
                    List<FileItem> list = servletFileUpload.parseRequest(req);
                    Integer pageNum = null;
                    Long goodsId = null;
                    String goodsName = null;
                    String goodsBrand = null;
                    BigDecimal goodsPrice = null;
                    Integer goodsSales = null;
                    Integer goodsRepertory = null;
                    String picture = null;
                    for (FileItem fileItem:list){
                        if (fileItem.isFormField()){
                            String name = fileItem.getFieldName();
                            switch (name){
                                case "pageNum":
                                    pageNum = Integer.valueOf(fileItem.getString());
                                    break;
                                case "goodsId":
                                    goodsId = Long.valueOf(fileItem.getString());
                                    break;
                                case "goodsName":
                                    goodsName = fileItem.getString("UTF-8");
                                    break;
                                case "goodsBrand":
                                    goodsBrand = fileItem.getString("UTF-8");
                                    break;
                                case "goodsPrice":
                                    goodsPrice = new BigDecimal(fileItem.getString());
                                    break;
                                case "goodsSales":
                                    goodsSales = Integer.valueOf(fileItem.getString());
                                    break;
                                case "goodsRepertory":
                                    goodsRepertory = Integer.valueOf(fileItem.getString());
                                    break;
                            }
                        }else{
                            if ("picture".equals(fileItem.getFieldName())){
                                picture = fileItem.getName();
                                if (!"".equals(picture)){
                                    fileItem.write(new File("C:\\Users\\Win\\IdeaProjects\\JavaTest\\shop\\web\\images\\"+picture));
                                }
                            }
                        }
                    }
                    System.out.println("页面数："+pageNum);
                    System.out.println("商品名称"+goodsName);
                    Goods goods = new Goods(goodsName,goodsBrand,goodsPrice,goodsSales,goodsRepertory,picture);
                    goods.setGoodsId(goodsId);
                    if (goodsService.updateGoods(goods)>0){
                        System.out.println("修改商品成功");
                    }else{
                        System.out.println("修改商品失败");
                    }
                    req.getRequestDispatcher("GoodsListServlet?action=behind&pageNum="+pageNum).forward(req,resp);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
