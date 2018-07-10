package leetcode

import org.junit.Test

class MaxIncreasetoKeepCitySkyline {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        var subValues:Int = 0;
        val columns = IntArray(grid.size) { -1 };
        val rows = IntArray(grid.get(0).size) { -1 };
        for (ss in grid.indices) {
            val ints = grid[ss]
            for (gg in ints.indices) {
                if (columns[ss] == -1) {
                    var max = -1;
                    for (i in ints.indices) {
                        if (grid[ss][i] > max) {
                            max = grid[ss][i];
                        }
                    }
                    columns[ss] = max;
                }
                if (rows[gg] == -1) {
                    var max = -1;
                    for (i in grid.indices) {
                        if (grid[i][gg] > max) {
                            max = grid[i][gg];
                        }
                    }
                    rows[gg] = max;
                }

                var currentRowColumnMaxValue:Int =
                        if (columns[ss] > rows[gg]) {
                            rows[gg];
                        } else {
                            columns[ss];
                        }
                subValues = subValues + currentRowColumnMaxValue - grid[ss][gg];
            }
        }
        return subValues;
    }

    @Test fun testFunction(){
        val grid = arrayOf(intArrayOf(3, 0, 8, 4), intArrayOf(2,4,5,7), intArrayOf(9,2,6,3), intArrayOf(0,3,1,0))
        val maxIncreaseKeepingSkyline = maxIncreaseKeepingSkyline(grid)
        println(maxIncreaseKeepingSkyline);
    }

}