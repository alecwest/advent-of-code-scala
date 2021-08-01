package com.alecnwest
package com.alecnwest.advent.puzzles.adapterarray

import advent.utils.InputParser
import org.scalatest.{Matchers, WordSpecLike}

class AdapterArrayTest extends WordSpecLike with Matchers {

  "AdapterArrayTest" when {
    "product1And3Differences" should {
      "return the product of example input" in {
        AdapterArray.product1And3Differences(
          InputParser.parse[Int](
            "28\n33\n18\n42\n31\n14\n46\n20\n48\n47\n24\n23\n49\n45\n19\n38\n39\n11\n1\n32\n25\n35\n8\n17\n7\n9\n4\n2\n34\n10\n3"
          )
        ) should be(220)
      }

      "return the product of puzzle input" in {
        AdapterArray.product1And3Differences(
          InputParser.parse[Int](
            "80\n87\n10\n122\n57\n142\n134\n59\n113\n139\n101\n41\n138\n112\n46\n96\n43\n125\n36\n54\n133\n17\n42\n98\n7\n114\n78\n67\n77\n28\n149\n58\n20\n105\n31\n19\n18\n27\n40\n71\n117\n66\n21\n72\n146\n90\n97\n94\n123\n1\n119\n30\n84\n61\n91\n118\n2\n29\n104\n73\n13\n76\n24\n148\n68\n111\n131\n83\n49\n8\n132\n9\n64\n79\n124\n95\n88\n135\n3\n51\n39\n6\n60\n108\n14\n35\n147\n89\n34\n65\n50\n145\n128"
          )
        ) should be(1885)
      }
    }

    "numberPossibleArrangements" should {
      "return the product of basic input" in {
        AdapterArray.numberPossibleArrangements(
          InputParser.parse[Int](
            "1\n4\n5\n6\n7\n10\n11\n12\n15\n16\n19"
          )
        ) should be(8)
      }

      "return the product of basic input 2" in {
        AdapterArray.numberPossibleArrangements(
          InputParser.parse[Int](
            "1\n2\n3\n4\n5\n8\n9\n10"
          )
        ) should be(26)
      }

      "return the product of example input" in {
        AdapterArray.numberPossibleArrangements(
          InputParser.parse[Int](
            "28\n33\n18\n42\n31\n14\n46\n20\n48\n47\n24\n23\n49\n45\n19\n38\n39\n11\n1\n32\n25\n35\n8\n17\n7\n9\n4\n2\n34\n10\n3"
          )
        ) should be(19208)
      }

      "return the product of puzzle input" in {
        AdapterArray.numberPossibleArrangements(
          InputParser.parse[Int](
            "80\n87\n10\n122\n57\n142\n134\n59\n113\n139\n101\n41\n138\n112\n46\n96\n43\n125\n36\n54\n133\n17\n42\n98\n7\n114\n78\n67\n77\n28\n149\n58\n20\n105\n31\n19\n18\n27\n40\n71\n117\n66\n21\n72\n146\n90\n97\n94\n123\n1\n119\n30\n84\n61\n91\n118\n2\n29\n104\n73\n13\n76\n24\n148\n68\n111\n131\n83\n49\n8\n132\n9\n64\n79\n124\n95\n88\n135\n3\n51\n39\n6\n60\n108\n14\n35\n147\n89\n34\n65\n50\n145\n128"
          )
        ) should be(2024782584832L)
      }
    }
  }
}
