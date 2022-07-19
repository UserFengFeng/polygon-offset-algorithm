package com.lee.test;

import com.lee.algorithm.OffsetAlgorithm;
import com.lee.display.MainWindow;
import com.lee.entity.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(1822, 3298),
                new Point(1855, 3311),
                new Point(1856, 3311),
                new Point(1856, 3311),
                new Point(1857, 3311),
                new Point(1857, 3311),
                new Point(1858, 3311),
                new Point(1875, 3303),
                new Point(1876, 3303),
                new Point(1877, 3302),
                new Point(1877, 3302),
                new Point(1877, 3301),
                new Point(1877, 3301),
                new Point(1889, 3270),
                new Point(1889, 3270),
                new Point(1890, 3269),
                new Point(1889, 3268),
                new Point(1889, 3268),
                new Point(1889, 3267),
                new Point(1881, 3249),
                new Point(1881, 3249),
                new Point(1880, 3248),
                new Point(1880, 3248),
                new Point(1879, 3247),
                new Point(1879, 3247),
                new Point(1860, 3240),
                new Point(1852, 3236),
                new Point(1844, 3230),
                new Point(1838, 3226),
                new Point(1831, 3223),
                new Point(1810, 3215),
                new Point(1810, 3215),
                new Point(1810, 3215),
                new Point(1810, 3215),
                new Point(1810, 3215),
                new Point(1810, 3215),
                new Point(1809, 3215),
                new Point(1809, 3215),
                new Point(1809, 3215),
                new Point(1809, 3216),
                new Point(1809, 3216),
                new Point(1808, 3218),
                new Point(1808, 3218),
                new Point(1808, 3218),
                new Point(1808, 3218),
                new Point(1808, 3218),
                new Point(1808, 3218),
                new Point(1808, 3219),
                new Point(1808, 3219),
                new Point(1809, 3219),
                new Point(1809, 3219),
                new Point(1809, 3219),
                new Point(1830, 3227),
                new Point(1830, 3227),
                new Point(1835, 3230),
                new Point(1840, 3233),
                new Point(1849, 3240),
                new Point(1859, 3245),
                new Point(1860, 3245),
                new Point(1871, 3249),
                new Point(1871, 3249),
                new Point(1872, 3250),
                new Point(1873, 3251),
                new Point(1874, 3252),
                new Point(1875, 3253),
                new Point(1881, 3267),
                new Point(1881, 3267),
                new Point(1881, 3269),
                new Point(1881, 3270),
                new Point(1881, 3271),
                new Point(1881, 3272),
                new Point(1873, 3294),
                new Point(1873, 3294),
                new Point(1872, 3296),
                new Point(1871, 3296),
                new Point(1870, 3297),
                new Point(1869, 3298),
                new Point(1859, 3302),
                new Point(1859, 3302),
                new Point(1857, 3303),
                new Point(1856, 3303),
                new Point(1855, 3303),
                new Point(1853, 3302),
                new Point(1827, 3292),
                new Point(1825, 3291),
                new Point(1824, 3290),
                new Point(1821, 3288),
                new Point(1820, 3288),
                new Point(1782, 3273),
                new Point(1782, 3273),
                new Point(1782, 3273),
                new Point(1781, 3273),
                new Point(1781, 3273),
                new Point(1781, 3273),
                new Point(1781, 3273),
                new Point(1781, 3273),
                new Point(1781, 3274),
                new Point(1781, 3274),
                new Point(1781, 3274),
                new Point(1779, 3279),
                new Point(1779, 3279),
                new Point(1779, 3279),
                new Point(1779, 3279),
                new Point(1779, 3279),
                new Point(1779, 3280),
                new Point(1779, 3280),
                new Point(1779, 3280),
                new Point(1779, 3280),
                new Point(1779, 3280),
                new Point(1779, 3280),
                new Point(1814, 3293),
                new Point(1816, 3294),
                new Point(1818, 3295),
                new Point(1820, 3297),
                new Point(1820, 3297),
                new Point(1821, 3298)
        );

        List<List<Point>> contours = new ArrayList<>();
        contours.add(points);


        BufferedImage bufferedImage = new BufferedImage(4212, 4806, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setBackground(new Color(0, 0, 0, 0));
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.RED);

        Path2D path2D = new Path2D.Double();
        for (int i = 0; i < contours.size(); i++) {
            List<Point> pointsList = contours.get(i);
            for (int i1 = 0; i1 < pointsList.size(); i1++) {
                Point point = pointsList.get(i1);
                double x = point.getX();
                double y = point.getY();
                if(i1 == 0) {
                    path2D.moveTo(x, y);
                } else if (i1 == contours.size() - 1) {
                    path2D.lineTo(x, y);
                    path2D.closePath();
                } else {
                    path2D.lineTo(x, y);
                }
            }

        }
        graphics.setColor(Color.GREEN);
        graphics.draw(path2D);

        // try {
        //     ImageIO.write(bufferedImage, "PNG", new File("D:\\project\\aaaaa1.jpg"));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        // 逐层获取内缩轮廓
        List<List<Point>> lists = OffsetAlgorithm.offsetAlgorithm(points, 9);

        Path2D path2D2 = new Path2D.Double();
        for (int i = 0; i < lists.size(); i++) {
            List<Point> points1 = lists.get(i);
            for (int i1 = 0; i1 < points1.size(); i1++) {
                Point point = points1.get(i1);
                double x = point.getX();
                double y = point.getY();
                if(i1 == 0) {
                    path2D2.moveTo(x, y);
                } else if (i1 == contours.size() - 1) {
                    path2D2.lineTo(x, y);
                    path2D2.closePath();
                } else {
                    path2D2.lineTo(x, y);
                }
            }
        }
        graphics.setColor(Color.red);
        graphics.draw(path2D2);

        try {
            ImageIO.write(bufferedImage, "PNG", new File("D:\\project\\aaaaa.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
