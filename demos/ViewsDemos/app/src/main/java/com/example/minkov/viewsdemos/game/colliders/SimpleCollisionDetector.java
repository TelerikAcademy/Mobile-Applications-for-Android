package com.example.minkov.viewsdemos.game.colliders;

import com.example.minkov.viewsdemos.game.objects.IShape;

public class SimpleCollisionDetector implements ICollisionDetector {
    public boolean areColliding(int x1, int y1, int w1, int h1,
                                int x2, int y2, int w2, int h2) {
        int left1 = x1;
        int right1 = x1 + w1;
        int top1 = y1;
        int bottom1 = y1 + h1;

        int left2 = x2;
        int right2 = x2 + w2;
        int top2 = y2;
        int bottom2 = y2 + h2;

        return ((left1 <= left2 && left2 <= right1) || (left1 <= right2 && right2 <= right1)) &&
                ((top1 <= top2 && top2 <= bottom1) || (top1 <= bottom2 && bottom2 <= bottom2));
    }

    @Override
    public boolean areColliding(IShape s1, IShape s2) {
        if (s2 == null) {
            return false;
        }
        return this.areColliding(s1.getX(), s1.getY(), s1.getWidth(), s1.getHeight(),
                s2.getX(), s2.getY(), s2.getWidth(), s2.getHeight());
    }
}
