package com.example.minkov.viewsdemos.game.colliders;

import com.example.minkov.viewsdemos.game.objects.IShape;

/**
 * Created by minkov on 2/22/17.
 */

public interface ICollisionDetector {
    boolean areColliding(IShape s1, IShape s2);
    boolean areColliding(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2);
}
