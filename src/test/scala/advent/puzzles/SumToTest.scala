package com.alecnwest
package advent.puzzles

import com.alecnwest.advent.utils.InputParser
import org.scalatest.{Matchers, WordSpecLike}

class SumToTest extends WordSpecLike with Matchers {

  "SumTo" should {
    "calculate product of 2 numbers summing to 2020" in {
      SumTo.calculate(IndexedSeq(1721, 979, 366, 299, 675, 1456), 2, 2020) should be(514579)
    }

    "calculate product of 2 numbers summing to 2020 with larger input" in {
      SumTo.calculate(InputParser.parse[Int]("1728\n1954\n1850\n1825\n1732\n1536\n1759\n1877\n1400\n1579\n1708\n1047\n1810\n558\n1132\n1608\n1857\n1756\n1834\n1743\n1888\n1660\n1642\n1726\n541\n1519\n1407\n1875\n1618\n1331\n1878\n1626\n1200\n1346\n1830\n1403\n1557\n1890\n1543\n823\n1435\n1903\n1377\n1931\n1885\n1422\n1411\n1563\n1818\n1643\n2004\n1364\n1446\n1071\n1699\n1140\n1617\n1974\n1758\n1537\n1980\n1709\n1812\n1178\n1822\n1648\n1517\n1477\n1935\n1848\n1534\n1734\n1484\n1985\n1485\n1963\n1329\n1809\n1380\n1552\n1895\n215\n1844\n1138\n1194\n1938\n1774\n1823\n684\n1948\n1941\n1062\n1550\n1602\n1920\n1391\n1666\n1327\n1791\n1721\n1928\n1805\n1574\n1658\n1467\n1852\n1924\n1679\n2008\n1989\n1719\n1884\n1776\n1806\n1750\n1897\n1781\n1667\n1544\n1100\n1838\n1839\n1744\n1715\n1481\n1480\n1548\n1707\n1362\n1681\n1616\n1956\n1639\n1911\n1655\n1685\n1670\n1789\n1571\n1661\n1647\n1379\n1522\n1965\n1482\n1158\n1970\n1945\n1384\n1535\n1383\n1613\n1511\n1896\n1784\n1513\n841\n1619\n1645\n1125\n1932\n1873\n639\n1657\n1554\n1979\n1516\n1995\n1899\n1347\n1175\n1918\n1872\n1559\n1094\n1423\n1883\n1846\n1394\n1488\n1343\n1905\n1914\n1578\n1943\n1388\n1286\n966\n1342\n1528\n1702\n1452\n1936\n2005\n1188\n1683\n1133\n447\n1072\n1893"), 2, 2020) should be(388075)
    }

    "calculate product of 3 numbers summing to 2020" in {
      SumTo.calculate(IndexedSeq(1721, 979, 366, 299, 675, 1456), 3, 2020) should be(241861950)
    }

    "calculate product of 3 numbers summing to 2020 with larger input" in {
      SumTo.calculate(InputParser.parse[Int]("1728\n1954\n1850\n1825\n1732\n1536\n1759\n1877\n1400\n1579\n1708\n1047\n1810\n558\n1132\n1608\n1857\n1756\n1834\n1743\n1888\n1660\n1642\n1726\n541\n1519\n1407\n1875\n1618\n1331\n1878\n1626\n1200\n1346\n1830\n1403\n1557\n1890\n1543\n823\n1435\n1903\n1377\n1931\n1885\n1422\n1411\n1563\n1818\n1643\n2004\n1364\n1446\n1071\n1699\n1140\n1617\n1974\n1758\n1537\n1980\n1709\n1812\n1178\n1822\n1648\n1517\n1477\n1935\n1848\n1534\n1734\n1484\n1985\n1485\n1963\n1329\n1809\n1380\n1552\n1895\n215\n1844\n1138\n1194\n1938\n1774\n1823\n684\n1948\n1941\n1062\n1550\n1602\n1920\n1391\n1666\n1327\n1791\n1721\n1928\n1805\n1574\n1658\n1467\n1852\n1924\n1679\n2008\n1989\n1719\n1884\n1776\n1806\n1750\n1897\n1781\n1667\n1544\n1100\n1838\n1839\n1744\n1715\n1481\n1480\n1548\n1707\n1362\n1681\n1616\n1956\n1639\n1911\n1655\n1685\n1670\n1789\n1571\n1661\n1647\n1379\n1522\n1965\n1482\n1158\n1970\n1945\n1384\n1535\n1383\n1613\n1511\n1896\n1784\n1513\n841\n1619\n1645\n1125\n1932\n1873\n639\n1657\n1554\n1979\n1516\n1995\n1899\n1347\n1175\n1918\n1872\n1559\n1094\n1423\n1883\n1846\n1394\n1488\n1343\n1905\n1914\n1578\n1943\n1388\n1286\n966\n1342\n1528\n1702\n1452\n1936\n2005\n1188\n1683\n1133\n447\n1072\n1893"), 3, 2020) should be(293450526)
    }
  }
}
