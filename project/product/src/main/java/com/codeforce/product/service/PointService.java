package com.codeforce.product.service;


import com.codeforce.product.model.Point;

import java.util.ArrayList;

interface PointService {
    ArrayList<Point> getAllFree();

    void addBoxToPoint(Point point, int i);

    boolean check_token_exists(Point point);
}

