# Topicwise-Solutions-To-Coding-Questions

Solutions to the algorithmic problems in [LeetCode](https://leetcode.com/problemset/algorithms/), [GeeksForGeeks](https://practice.geeksforgeeks.org/explore/?problemType=full&page=1), [Hackerrank](https://www.hackerrank.com/domains/algorithms?filters%5Bstatus%5D%5B%5D=unsolved&badge_type=problem-solving), [Interviewbit](https://www.interviewbit.com/courses/programming/) and [Codeforces](https://codeforces.com/problemset) written in **C++** and **JAVA**

## What you can find in this repository

We have solved quite a number of problems from several topics. See the below table for further details.

## How to contribute?

1. Fork the repository
2. Do the desired changes (add/delete/modify)
3. Make a pull request

If you want to update the readme file as well, you have to install [Java](https://www.tutorialspoint.com/java/java_environment_setup.htm) and [Jsoup](https://www.tutorialspoint.com/jsoup/jsoup_environment.htm). Then you can run the [UpdateReadme.java](./UpdateReadme.java) file to update the readme file.

## When to contribute?

1. If there is no solution to a problem in the main branch
2. If your solution is asymptotically faster than the one in the main branch
3. If your algorithm is of the same time complexity but with reduced code size (In this case, comment out the original solution and make a pull request with your solution.)
4. If you have another method of solving the problem which is asymptotically slower than the original method (In this case, comment your solution in the main file and make a pull request.)
5. If you want to update the [UpdateReadme.java](./UpdateReadme.java) file

## Format for solution files

1. Paste the link for the question within comments.
2. Paste the solution.
3. Save with proper extension name.

## Description of auto-updation of Readme file

[UpdateReadme.java](./UpdateReadme.java) is the main file. It reads information (that are obtained online) from [OnlineInfo.csv](./OnlineInfo.csv) file. If you have updated the readme file with some online information without adding into csv file, then you need to run [OnlineToCSV.java](./OnlineToCSV.java) file to read that from readme and store in the csv file.

For difficulty level, csv file is already updated. For other online information columns you'll have to update it.

## Algorithms

Number of Problems Solved (01-Aug-2022 17:34:45)

| Topic Name | Java | CPP | 
| :--------: | :--------: | :--------: | 
| [Arrays](https://github.com/prateekshyap/DSA#arrays) | 106 | 44 |
| [BackTracking](https://github.com/prateekshyap/DSA#backtracking) | 28 | 5 |
| [Bit-Magic](https://github.com/prateekshyap/DSA#bit-magic) | 28 | 21 |
| [Codeforces](https://github.com/prateekshyap/DSA#codeforces) | 76 | 1 |
| [Disjoint-Set](https://github.com/prateekshyap/DSA#disjoint-set) | 4 | 0 |
| [Dynamic-Programming](https://github.com/prateekshyap/DSA#dynamic-programming) | 123 | 15 |
| [Graph](https://github.com/prateekshyap/DSA#graph) | 66 | 19 |
| [Greedy](https://github.com/prateekshyap/DSA#greedy) | 28 | 7 |
| [Hashing](https://github.com/prateekshyap/DSA#hashing) | 43 | 9 |
| [Heap](https://github.com/prateekshyap/DSA#heap) | 24 | 9 |
| [Linked-List](https://github.com/prateekshyap/DSA#linked-list) | 57 | 20 |
| [Matrix](https://github.com/prateekshyap/DSA#matrix) | 45 | 20 |
| [Miscellaneous](https://github.com/prateekshyap/DSA#miscellaneous) | 65 | 3 |
| [Queue](https://github.com/prateekshyap/DSA#queue) | 6 | 6 |
| [Recursion](https://github.com/prateekshyap/DSA#recursion) | 13 | 12 |
| [Searching](https://github.com/prateekshyap/DSA#searching) | 40 | 31 |
| [Segment-Tree](https://github.com/prateekshyap/DSA#segment-tree) | 2 | 0 |
| [Sorting](https://github.com/prateekshyap/DSA#sorting) | 13 | 7 |
| [Stack](https://github.com/prateekshyap/DSA#stack) | 24 | 7 |
| [Strings](https://github.com/prateekshyap/DSA#strings) | 88 | 14 |
| [Tree](https://github.com/prateekshyap/DSA#tree) | 163 | 26 |
| [Trie](https://github.com/prateekshyap/DSA#trie) | 13 | 2 |
| Total | 1055 | 278 |

## Reference

* C++
	* [STL Time Complexity (Detailed)](http://www.cplusplus.com/reference/stl/)
	* [STL Time Complexity (Summary)](http://john-ahlgren.blogspot.com/2013/10/stl-container-performance.html)
	* [Data Structure and Algorithms Cheat Sheet](https://github.com/gibsjose/cpp-cheat-sheet/blob/master/Data%20Structures%20and%20Algorithms.md)
* JAVA
	* [Time Complexity](to-be-updated)

## Arrays

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Rearrange Array Alternately 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1) |[Java](./Arrays/AlternativeRearrangement.java) |Medium|O(n)||
|  2  |3sum With Multiplicity|[LC](https://leetcode.com/problems/3sum-with-multiplicity/) |[Java](./Arrays/3SumWithMultiplicity.java) ||O(n<sup>2</sup>)||
|  3  |Arithmetic Sequences|[BS](https://binarysearch.com/problems/Arithmetic-Sequences) |[Java](./Arrays/ArithmeticSequences.java) ||O(n<sup>2</sup>)||
|  4  |Dropped Sensor Metric|[BS](https://binarysearch.com/problems/Dropped-Sensor-Metric) |[CPP](./Arrays/BS_DroppedSensorMetric.cpp) ||O(1)||
|  5  |K Distinct Window|[BS](https://binarysearch.com/problems/K-Distinct-Window) |[Java](./Arrays/KDistinctWindow.java) ||O(n)||
|  6  |Largest Sublist Sum|[BS](https://binarysearch.com/problems/Largest-Sublist-Sum) [LC](https://leetcode.com/problems/maximum-subarray/) |[Java](./Arrays/MaximumSumSubarray.java) ||O(n)||
|  7  |Largest And Smallest Difference|[BS](https://binarysearch.com/problems/Largest-and-Smallest-Difference) |[Java](./Arrays/LargestAndSmallestDifference.java) ||O(n)||
|  8  |Majority Vote|[BS](https://binarysearch.com/problems/Majority-Vote) [LC](https://leetcode.com/problems/majority-element/) |[Java](./Arrays/MajorityElement.java) ||O(n)||
|  9  |Maximum Absolute Value Of Sublist|[BS](https://binarysearch.com/problems/Maximum-Absolute-Value-of-Sublist) |[Java](./Arrays/MaximumAbsoluteValueOfSublist.java) ||O(n)||
|  10  |Number Of K Length Sublists With Average At Least Target|[BS](https://binarysearch.com/problems/Number-of-K-Length-Sublists-with-Average-at-Least-Target) |[Java](./Arrays/KLengthSublistsWithAverageAtLeastTarget.java) ||O(n)||
|  11  |Rain Catcher|[BS](https://binarysearch.com/problems/Rain-Catcher) [LC](https://leetcode.com/problems/trapping-rain-water/) |[Java](./Arrays/TrappingRainWater.java) ||O(n)||
|  12  |Remove Duplicates Occurring More Than Twice|[BS](https://binarysearch.com/problems/Remove-Duplicates-Occurring-More-Than-Twice) [LC](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/) |[CPP](./Arrays/LC_80_RemoveDuplicatesFromSortedArrayII.cpp) [Java](./Arrays/RemoveDuplicatesFromSortedArray2.java) ||O(n)||
|  13  |Set Split|[BS](https://binarysearch.com/problems/Set-Split) |[Java](./Arrays/SetSplit.java) ||O(n)||
|  14  |Split String With Same Distinct Counts|[BS](https://binarysearch.com/problems/Split-String-with-Same-Distinct-Counts) [LC](https://leetcode.com/problems/number-of-good-ways-to-split-a-string/) |[Java](./Arrays/NumberOfGoodSplits.java) ||O(n)||
|  15  |Submajority Vote|[BS](https://binarysearch.com/problems/Submajority-Vote) [LC](https://leetcode.com/problems/majority-element-ii/) |[Java](./Arrays/MajorityElement-ii.java) ||O(n)||
|  16  |XOR Range Queries|[BS](https://binarysearch.com/problems/XOR-Range-Queries) |[Java](./Arrays/XORRangeQueries.java) ||O(n)||
|  17  |Array Of Alternate Ve And Ve Nos1401|[GFG](https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1) |[Java](./Arrays/AlternatePositiveNegative.java) |Easy|O(n<sup>2</sup>)||
|  18  |Bag Of Tokens|[LC](https://leetcode.com/problems/bag-of-tokens/) |[Java](./Arrays/BagOfTokens.java) ||O(n)||
|  19  |Best Time To Buy And Sell Stock|[LC](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) |[CPP](./Arrays/LC_121_BestTimeToBuySellStock.cpp) ||O(1)||
|  20  |Best Time To Buy And Sell Stock Ii|[LC](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) [GFG](https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1) |[Java](./Arrays/StockBuyAndSell.java) |Medium|O(n)||
|  21  |Binary Subarrays With Sum|[LC](https://leetcode.com/problems/binary-subarrays-with-sum/) |[Java](./Arrays/BinarySubarraysWithSum.java) ||O(n)||
|  22  |Boats To Save People|[LC](https://leetcode.com/problems/boats-to-save-people/) |[Java](./Arrays/BoatsToSavePeople.java) ||O(n)||
|  23  |Chocolate Distribution Problem3825|[GFG](https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1) |[Java](./Arrays/ChocolateDistribution.java) |Easy|O(n)||
|  24  |Common Elements1132|[GFG](https://practice.geeksforgeeks.org/problems/common-elements1132/1) |[Java](./Arrays/CommonElements.java) |Easy|O(n)||
|  25  |Contiguous Array|[LC](https://leetcode.com/problems/contiguous-array/) |[CPP](./Arrays/LC_525_ContiguousArrayZeroOne.cpp) [Java](./Arrays/ContiguousArray.java) ||O(n)||
|  26  |Count Number Of Nice Subarrays|[LC](https://leetcode.com/problems/count-number-of-nice-subarrays/) |[Java](./Arrays/CountNumberOfNiceSubarrays.java) ||O(n)||
|  27  |Count Pairs With Given Sum5022|[GFG](https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1) |[Java](./Arrays/CountPairSum.java) |Easy|O(n)||
|  28  |Count Smaller Elements2214|[GFG](https://practice.geeksforgeeks.org/problems/count-smaller-elements2214/1) |[Java](./Arrays/CountSmallerElements.java) |null|O(n)||
|  29  |Count Subarrays With Equal Number Of 1s And 0s 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1#) |[CPP](./Arrays/GFG_CountSubarrWithEqual1sAnd0s.cpp) [Java](./Arrays/TotalSubarraysWithEqualZerosAndOnes.java) |Medium|O(1)||
|  30  |Count Subarrays With Score Less Than K|[LC](https://leetcode.com/problems/count-subarrays-with-score-less-than-k/) |[Java](./Arrays/CountSubarraysWithScoreLessThanK.java) ||O(n<sup>2</sup>)||
|  31  |Count The Subarrays Having Product Less Than K1708|[GFG](https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1) |[Java](./Arrays/CountSubArrays.java) |Hard|O(n<sup>2</sup>)||
|  32  |Crush|[HR](https://www.hackerrank.com/challenges/crush/) |[Java](./Arrays/ArrayManipulation.java) ||O(n)||
|  33  |Cyclically Rotate An Array By One2614|[GFG](https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1#) |[CPP](./Arrays/GFG_CyclicallyRotateAnArrayByOne.cpp) [Java](./Arrays/SingleCyclicRotation.java) |Basic|O(1)||
|  34  |Distinct Absolute Array Elements4529|[GFG](https://practice.geeksforgeeks.org/problems/distinct-absolute-array-elements4529/1#) |[CPP](./Arrays/GFG_CountDistinct.cpp) [Java](./Arrays/DistinctAbsoluteArrayElements.java) |Easy|O(n<sup>2</sup>)||
|  35  |Factorials Of Large Numbers2508|[GFG](https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1) |[Java](./Arrays/LargeFactorial.java) |Medium|O(n<sup>2</sup>)||
|  36  |Find Missing Observations|[LC](https://leetcode.com/problems/find-missing-observations/) |[Java](./Arrays/FindMissingObservations.java) ||O(n)||
|  37  |Find Pivot Index|[LC](https://leetcode.com/problems/find-pivot-index/) [GFG](https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1) |[CPP](./Arrays/LC_724_ARR_EquilibriumPoints.cpp) [Java](./Arrays/EquilibriumPoint.java) |Easy|O(n)||
|  38  |Find Target Indices After Sorting Array|[LC](https://leetcode.com/problems/find-target-indices-after-sorting-array/) |[Java](./Arrays/FindTargetIndicesAfterSortingArray.java) ||O(n)||
|  39  |Find The Duplicate Number|[LC](https://leetcode.com/problems/find-the-duplicate-number/) |[CPP](./Arrays/LC_287_FindDuplicateNumber.cpp) [Java](./Arrays/FindDuplicate.java) ||O(n)||
|  40  |Fruit Into Baskets|[LC](https://leetcode.com/problems/fruit-into-baskets/) |[Java](./Arrays/FruitIntoBaskets.java) ||O(n<sup>2</sup>)||
|  41  |Insert Interval|[LC](https://leetcode.com/problems/insert-interval/) |[CPP](./Arrays/LC_57_InsertInterval.cpp) [Java](./Arrays/InsertNewInterval.java) ||O(n)||
|  42  |Intersection Of Two Arrays Ii|[LC](https://leetcode.com/problems/intersection-of-two-arrays-ii/) [LC](https://leetcode.com/problems/intersection-of-two-arrays/) [GFG](https://practice.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1#) |[CPP](./Arrays/GFG_IntersectionOfTwoArrays.cpp) [Java](./Arrays/IntersectionArrays.java) |Easy|O(1)||
|  43  |Inversion Of Array 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1) |[Java](./Arrays/InversionCount.java) |Medium|O(n)||
|  44  |Jump Game|[GFG](https://practice.geeksforgeeks.org/problems/jump-game/1/#) |[Java](./Arrays/JumpGame.java) |Medium|O(n)||
|  45  |K Divisible Elements Subarrays|[LC](https://leetcode.com/problems/k-divisible-elements-subarrays/) |[Java](./Arrays/KDivisibleElementsSubarrays.java) ||O(n)||
|  46  |Kth Smallest Element5635|[GFG](https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1#) |[CPP](./Arrays/GFG_ARR_KthSmallestElement.cpp) [Java](./Arrays/KthSmallestElement.java) |Medium|O(1)||
|  47  |Large Factorial4721|[GFG](https://practice.geeksforgeeks.org/problems/large-factorial4721/1/) |[Java](./Arrays/LargeFactorialArray.java) |Medium|O(n)||
|  48  |Largest Number Formed From An Array1117|[GFG](https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1/) |[Java](./Arrays/LargestNumberFormedFromAnArray.java) |Medium|O(n)||
|  49  |Leaders In An Array 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1) |[CPP](./Arrays/GFG_ARR_LeadersInArray.cpp) [Java](./Arrays/LeadersInArray.java) |Easy|O(1)||
|  50  |Longest Consecutive Sequence|[LC](https://leetcode.com/problems/longest-consecutive-sequence/) [GFG](https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1) |[Java](./Arrays/LongestConsecutiveSubsequence.java) |Medium|O(n<sup>2</sup>)||
|  51  |Longest Continuous Subarray With Absolute Diff Less Than Or Equal To Limit|[LC](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) |[Java](./Arrays/LongestContiguousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.java) ||O(n<sup>2</sup>)||
|  52  |Majority Element|[LC](https://leetcode.com/problems/majority-element/) [GFG](https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1/) |[CPP](./Arrays/LC_169_MajorityElement.cpp) |Medium|O(1)||
|  53  |Majority Element Ii|[LC](https://leetcode.com/problems/majority-element-ii/) |[CPP](./Arrays/LC_229_MajorityElementII.cpp) ||O(1)||
|  54  |Max Circular Subarray Sum 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1) |[Java](./Arrays/MaxCircularSubarraySum.java) |Hard|O(n)||
|  55  |Max Consecutive Ones Iii|[LC](https://leetcode.com/problems/max-consecutive-ones-iii/) |[Java](./Arrays/MaxConsecutiveOnes3.java) ||O(n<sup>2</sup>)||
|  56  |Max Distance Between Same Elements|[GFG](https://practice.geeksforgeeks.org/problems/max-distance-between-same-elements/1) |[Java](./Arrays/MaxDistanceBetweenSameElement.java) |Easy|O(n)||
|  57  |Max Sum Subarray Of Size K5313|[GFG](https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1) |[CPP](./Arrays/GFG_ARR_MaximumSumSubarrayOfSizeK.cpp) [Java](./Arrays/MaximumSumSubarrayOfSizeK.java) |Basic|O(1)||
|  58  |Maximize Number Of 1s0905|[GFG](https://practice.geeksforgeeks.org/problems/maximize-number-of-1s0905/1) |[Java](./Arrays/MaximizeOnes.java) |Medium|O(n)||
|  59  |Maximum Difference Of Zeros And Ones In Binary String4111|[GFG](https://practice.geeksforgeeks.org/problems/maximum-difference-of-zeros-and-ones-in-binary-string4111/1#.) |[CPP](./Arrays/GFG_MaxDiffZerosAndOnesinBinary.cpp) [Java](./Arrays/MaximumDifferenceInBinaryString.java) |Easy|O(1)||
|  60  |Maximum Index 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1) |[Java](./Arrays/MaximumIndex.java) |Medium|O(n<sup>2</sup>)||
|  61  |Maximum Product Subarray3604|[GFG](https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1) |[Java](./Arrays/MaximumProductSubarray.java) |Medium|O(n)||
|  62  |Maximum Product Subset Of An Array|[GFG](https://practice.geeksforgeeks.org/problems/maximum-product-subset-of-an-array/1/) |[Java](./Arrays/MaximumProductSubsetOfAnArray.java) |Medium|O(n)||
|  63  |Maximum Subarray|[LC](https://leetcode.com/problems/maximum-subarray/) [GFG](https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1/) |[CPP](./Arrays/LC_53_MaximumSubarray.cpp) |Medium|O(1)||
|  64  |Median Of 2 Sorted Arrays Of Different Sizes|[GFG](https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1/) |[Java](./Arrays/MedianOfTwoSortedArraysOfDifferentSizes.java) |Hard|O(n)||
|  65  |Merge Intervals|[LC](https://leetcode.com/problems/merge-intervals/) [GFG](https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1/#) |[CPP](./Arrays/LC_56_MergeIntervals.cpp) [Java](./Arrays/MergeIntervals.java) |Medium|O(1)||
|  66  |Merge Two Sorted Arrays5135|[GFG](https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1#) |[CPP](./Arrays/GFG_MergeWithoutExtraArray.cpp) [Java](./Arrays/MergeWithoutExtraSpace.java) |Hard|O(1)||
|  67  |Minimize Maximum Pair Sum In Array|[LC](https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/) |[Java](./Arrays/MinimizeMaximumPairSumInArray.java) ||O(n<sup>2</sup>)||
|  68  |Minimize The Heights3351|[GFG](https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1/) |[Java](./Arrays/MinimizeTheHeights.java) |Medium|O(n)||
|  69  |Minimum Number Of Jumps 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1) |[Java](./Arrays/MinimumJumps.java) |Medium|O(n)||
|  70  |Minimum Size Subarray Sum|[LC](https://leetcode.com/problems/minimum-size-subarray-sum/) |[CPP](./Arrays/LC_209_MinSizeSubArraySum.cpp) [Java](./Arrays/MinimumSizeSubarraySum.java) ||O(1)||
|  71  |Move All Negative Elements To End1813|[GFG](https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1#) |[CPP](./Arrays/GFG_MoveAllNegEleToEnd.cpp) [Java](./Arrays/SegregateNegativePositive.java) |Easy|O(1)||
|  72  |Move Zeroes|[LC](https://leetcode.com/problems/move-zeroes/) |[Java](./Arrays/MoveZeros.java) ||O(n<sup>2</sup>)||
|  73  |Next Higher Palindromic Number Using The Same Set Of Digits5859|[GFG](https://practice.geeksforgeeks.org/problems/next-higher-palindromic-number-using-the-same-set-of-digits5859/1) |[Java](./Arrays/NextGreaterPalindrome.java) |Medium|O(n)||
|  74  |Next Permutation|[LC](https://leetcode.com/problems/next-permutation/) |[CPP](./Arrays/LC_31_NextPermutation.cpp) [Java](./Arrays/NextPermutation.java) ||O(1)||
|  75  |Number Of Good Ways To Split A String|[LC](https://leetcode.com/problems/number-of-good-ways-to-split-a-string/) |[CPP](./Arrays/LC_1525_NumOfGoodWaysToSplit.cpp) ||O(1)||
|  76  |Number Of Sub Arrays Of Size K And Average Greater Than Or Equal To Threshold|[LC](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/) |[CPP](./Arrays/LC_1343_NumOfSubArrayofSizeKandAvgGreaterThanThreshold.cpp) [Java](./Arrays/SubArrayAvgMoreThanThreshold.java) ||O(1)||
|  77  |Number Of Subsequences That Satisfy The Given Sum Condition|[LC](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/) |[Java](./Arrays/NumberOfSubsequencesThatSatisfyTheGivenSumCondition.java) ||O(n)||
|  78  |Number Of Zero Filled Subarrays|[LC](https://leetcode.com/problems/number-of-zero-filled-subarrays/) |[Java](./Arrays/NumberOfZeroFilledSubarrays.java) ||O(n)||
|  79  |Pairs Of Songs With Total Durations Divisible By 60|[LC](https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/) |[Java](./Arrays/SongSelect.java) ||O(n)||
|  80  |Palindrome String0817|[GFG](https://practice.geeksforgeeks.org/problems/palindrome-string0817/1) |[Java](./Arrays/PalindromeString.java) |Easy|O(1)||
|  81  |Partition Array Into Three Parts With Equal Sum|[LC](https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/) |[CPP](./Arrays/LC_1013_ARR_ThreeEqualParts.cpp) [Java](./Arrays/ThreeParts.java) ||O(1)||
|  82  |Partition Array Such That Maximum Difference Is K|[LC](https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/) |[Java](./Arrays/PartitionArraySuchThatMaximumDifferenceIsK.java) ||O(n)||
|  83  |Partitions|[IB](https://www.interviewbit.com/problems/partitions/) |[Java](./Arrays/Partitions.java) ||O(n<sup>2</sup>)||
|  84  |Pick From Both Sides|[IB](https://www.interviewbit.com/problems/pick-from-both-sides/) |[Java](./Arrays/PickFromBothSides.java) ||O(n)||
|  85  |Plus One|[GFG](https://practice.geeksforgeeks.org/problems/plus-one/1/) |[Java](./Arrays/AddOne.java) |Easy|O(n)||
|  86  |Product Of Array Except Self|[LC](https://leetcode.com/problems/product-of-array-except-self/) |[CPP](./Arrays/LC_288_ARR_ProductOfArrayExceptSelf.cpp) [Java](./Arrays/ProductPuzzle.java) ||O(1)||
|  87  |Rearrange An Array With O1 Extra Space3142|[GFG](https://practice.geeksforgeeks.org/problems/rearrange-an-array-with-o1-extra-space3142/1) |[Java](./Arrays/RearrangeWithZeroExtraSpace.java) |Medium|O(n<sup>2</sup>)||
|  88  |Remove Duplicates From Sorted Array|[LC](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) |[CPP](./Arrays/LC_26_RemoveDuplicatesSortedArray.cpp) [Java](./Arrays/RemoveDuplicatesFromSortedArray.java) ||O(1)||
|  89  |Replace Elements With Greatest Element On Right Side|[LC](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/) |[Java](./Arrays/ReplaceWithLargestOnRight.java) ||O(n<sup>2</sup>)||
|  90  |Reverse An Array|[GFG](https://practice.geeksforgeeks.org/problems/reverse-an-array/0) |[CPP](./Arrays/GFG_ARR_ReverseArray.cpp) [Java](./Arrays/ReverseArray.java) |School|O(1)||
|  91  |Rotate And Delete 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/rotate-and-delete-1587115621/1) |[Java](./Arrays/RotateAndDelete.java) |Medium|O(n)||
|  92  |Rotate Array|[LC](https://leetcode.com/problems/rotate-array/) |[CPP](./Arrays/LC_189_ARR_RotateArray.cpp) [Java](./Arrays/RotateArray.java) ||O(1)||
|  93  |Shortest Subarray With Sum At Least K|[LC](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) |[Java](./Arrays/ShortestSubarrayWithSumAtLeastK.java) ||O(n<sup>2</sup>)||
|  94  |Shortest Unsorted Continuous Subarray|[LC](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/) |[Java](./Arrays/ShortestUnsortedContinuousSubarray.java) ||O(n)||
|  95  |Smallest Subarray With Sum Greater Than X5651|[GFG](https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1) |[Java](./Arrays/SmallestSubarrayGreaterThanX.java) |null|O(n<sup>2</sup>)||
|  96  |Smallest Subset With Greater Sum|[GFG](https://practice.geeksforgeeks.org/problems/smallest-subset-with-greater-sum/1/) |[Java](./Arrays/SmallestSubsetWithGreaterSum.java) |Easy|O(n)||
|  97  |Smallest Sum Contiguous Subarray|[GFG](https://practice.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1/) |[Java](./Arrays/SmallestSumContiguousSubarray.java) |Medium|O(n)||
|  98  |Sort An Array Of 0s 1s And 2s4231|[GFG](https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1#) |[CPP](./Arrays/GFG_ARR_ArraySort0_1_2.cpp) [Java](./Arrays/SortZeroOneTwo.java) |Easy|O(1)||
|  99  |Sort Colors|[LC](https://leetcode.com/problems/sort-colors/) |[CPP](./Arrays/LC_775_SortColors.cpp) [Java](./Arrays/ZeroOneTwoSort.java) ||O(1)||
|  100  |Stickler Theif 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1#) |[CPP](./Arrays/GFG_ARR_MaxSumNonAdj_SticklerThief.cpp) |Easy|O(1)||
|  101  |Stock Buy And Sell 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1#) |[CPP](./Arrays/GFG_StockBuyAndSell.cpp) |Medium|O(1)||
|  102  |Subarray Sum Equals K|[LC](https://leetcode.com/problems/subarray-sum-equals-k/) |[CPP](./Arrays/LC_560_CountSubarraySumEqualsK.cpp) [Java](./Arrays/TotalSubarrays.java) ||O(1)||
|  103  |Subarray With 0 Sum 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1#) |[CPP](./Arrays/GFG_SubarrayWithZeroSum.cpp) [Java](./Arrays/SubarrayWithZeroSum.java) |Easy|O(1)||
|  104  |Subarray With Given Sum 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1#) |[CPP](./Arrays/GFG_SubarrayWithGivenSum.cpp) [Java](./Arrays/SubarrayWithGivenSum.java) |Easy|O(1)||
|  105  |Subarrays With K Different Integers|[LC](https://leetcode.com/problems/subarrays-with-k-different-integers/) |[Java](./Arrays/SubarraysWithKDifferentIntegers.java) ||O(n)||
|  106  |Sum Of All Odd Length Subarrays|[LC](https://leetcode.com/problems/sum-of-all-odd-length-subarrays/) |[Java](./Arrays/SumOfAllOddLengthSubarrays.java) ||O(n<sup>2</sup>)||
|  107  |Sum Of Middle Elements Of Two Sorted Arrays2305|[GFG](https://practice.geeksforgeeks.org/problems/sum-of-middle-elements-of-two-sorted-arrays2305/1/) |[Java](./Arrays/SumOfMiddleElementsOfTwoSortedArrays.java) |Medium|O(n)||
|  108  |Summary Ranges|[LC](https://leetcode.com/problems/summary-ranges/) |[Java](./Arrays/SummaryRanges.java) ||O(n)||
|  109  |Three Way Partitioning|[GFG](https://practice.geeksforgeeks.org/problems/three-way-partitioning/1) |[Java](./Arrays/ThreeWayPartitioning.java) |Easy|O(n)||
|  110  |Trapping Rain Water|[LC](https://leetcode.com/problems/trapping-rain-water/) |[CPP](./Arrays/LC_42_TrappingRainWater.cpp) ||O(1)||
|  111  |Triplet Sum In Array 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1) |[CPP](./Arrays/GFG_ARR_TripletSum.cpp) |Medium|O(1)||
|  112  |Union Of Two Arrays3538|[GFG](https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1#) |[CPP](./Arrays/GFG_UnionTwoArrays.cpp) [Java](./Arrays/UnionArrays.java) |Basic|O(1)||
|  113  |Union Of Two Sorted Arrays|[GFG](https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays/1#) |[CPP](./Arrays/GFG_UnionTwoSortedArrays.cpp) [Java](./Arrays/UnionSortedArrays.java) |Easy|O(1)||
|  114  |Wave Array 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1/) |[Java](./Arrays/WaveArray.java) |Easy|O(n)||
|  115  |Ways To Make A Fair Array|[LC](https://leetcode.com/problems/ways-to-make-a-fair-array/) |[Java](./Arrays/WaysToMakeAFairArray.java) ||O(n)||
|  116  |Zero Sum Subarrays1825|[GFG](https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1) |[CPP](./Arrays/GFG_CountSubarrySumZero.cpp) [Java](./Arrays/TotalZeroSumSubarrays.java) |Medium|O(1)||
## BackTracking

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Additive Number|[LC](https://leetcode.com/problems/additive-number/) |[Java](./BackTracking/AdditiveNumber.java) ||O(n)||
|  2  |All Unique Permutations Of An Array|[GFG](https://practice.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1) |[Java](./BackTracking/UniquePermutations.java) |Medium|O(n)||
|  3  |Combination Sum|[LC](https://leetcode.com/problems/combination-sum/) [GFG](https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1) |[Java](./BackTracking/CombinationSum.java) |Medium|O(n)||
|  4  |Combination Sum Ii|[LC](https://leetcode.com/problems/combination-sum-ii/) |[Java](./BackTracking/CombinationSum2.java) ||O(n)||
|  5  |Combination Sum Iii|[LC](https://leetcode.com/problems/combination-sum-iii/) |[Java](./BackTracking/CombinationSum3.java) ||O(n)||
|  6  |Combination Sum Iv|[LC](https://leetcode.com/problems/combination-sum-iv/) |[Java](./BackTracking/CombinationSum4.java) ||O(n)||
|  7  |Design Add And Search Words Data Structure|[LC](https://leetcode.com/problems/design-add-and-search-words-data-structure/) |[Java](./BackTracking/AddSearchWord.java) ||O(n<sup>2</sup>)||
|  8  |Fair Distribution Of Cookies|[LC](https://leetcode.com/problems/fair-distribution-of-cookies/) |[Java](./BackTracking/FairDistributionOfCookies.java) ||O(n)||
|  9  |Find Whether Path Exist5238|[GFG](https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1/) |[Java](./BackTracking/FindIfPathExists.java) |Medium|O(n<sup>2</sup>)||
|  10  |Generate Parentheses|[LC](https://leetcode.com/problems/generate-parentheses/) |[CPP](./BackTracking/LC_22_GenParenthesis.cpp) [Java](./BackTracking/GenerateParantheses.java) ||O(n)||
|  11  |Largest Number In K Swaps 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1) |[Java](./BackTracking/LargestNumberInKSwaps.java) |Medium|O(n<sup>2</sup>)||
|  12  |N Queens|[LC](https://leetcode.com/problems/n-queens/) |[Java](./BackTracking/NQueenSolver.java) ||O(n<sup>2</sup>)||
|  13  |Number Of Paths0926|[GFG](https://practice.geeksforgeeks.org/problems/number-of-paths0926/1#) |[CPP](./BackTracking/GFG_NumOfPaths.cpp) [Java](./BackTracking/PossiblePaths.java) |Easy|O(1)||
|  14  |Palindrome Partitioning|[LC](https://leetcode.com/problems/palindrome-partitioning/) [GFG](https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1/) |[Java](./BackTracking/PalindromicPartition.java) |Hard|O(n)||
|  15  |Palindrome Partitioning Ii|[LC](https://leetcode.com/problems/palindrome-partitioning-ii/) |[Java](./BackTracking/MinimumNumberOfPartitions.java) ||O(n)||
|  16  |Partition A Set Into Two Subsets Such That The Difference Of Subset Sums Is Minimum Set 2|[GFG](https://practice.geeksforgeeks.org/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum-set-2/1/) |[Java](./BackTracking/PartitionIntoSubsetsOfMinimumDifference.java) |Hard|O(1)||
|  17  |Partition Array To K Subsets|[GFG](https://practice.geeksforgeeks.org/problems/partition-array-to-k-subsets/1) |[Java](./BackTracking/FindKPartitions.java) |Hard|O(n)||
|  18  |Permutations|[LC](https://leetcode.com/problems/permutations/) [GFG](https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string-1587115620/1#) |[CPP](./BackTracking/GFG_StringPermutations.cpp) [Java](./BackTracking/Permutation.java) |Easy|O(1)||
|  19  |Permutations Ii|[LC](https://leetcode.com/problems/permutations-ii/) |[CPP](./BackTracking/LC_47_Permutations2.cpp) [Java](./BackTracking/IntegersWithDuplicatesPermutation.java) ||O(n)||
|  20  |Rat In A Maze Problem|[GFG](https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#) |[CPP](./BackTracking/GFG_RatInMaze.cpp) [Java](./BackTracking/RatInMaze.java) |Medium|O(1)||
|  21  |Remove Invalid Parentheses|[LC](https://leetcode.com/problems/remove-invalid-parentheses/) |[Java](./BackTracking/RemoveInvalidParentheses.java) ||O(n)||
|  22  |Solve The Sudoku 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1) |[Java](./BackTracking/SudokuSolver.java) |Hard|O(n<sup>2</sup>)||
|  23  |Split Array Into Fibonacci Sequence|[LC](https://leetcode.com/problems/split-array-into-fibonacci-sequence/) |[Java](./BackTracking/SplitArrayIntoFibonacciSequences.java) ||O(n)||
|  24  |Subset Sums Between The Given Range|[GFG](https://practice.geeksforgeeks.org/problems/subset-sums-between-the-given-range/1/) |[Java](./BackTracking/SubsetSumsBetweenTheGivenRange.java) |Hard|O(1)||
|  25  |Travelling Salesman Problem2732|[GFG](https://practice.geeksforgeeks.org/problems/travelling-salesman-problem2732/1/) |[Java](./BackTracking/TravellingSalesmanProblem.java) |Hard|O(n)||
|  26  |Word Break Part 23249|[GFG](https://practice.geeksforgeeks.org/problems/word-break-part-23249/1) |[Java](./BackTracking/WordBreak.java) |Hard|O(n<sup>2</sup>)||
|  27  |Word Search|[LC](https://leetcode.com/problems/word-search/) |[Java](./BackTracking/WordSearch.java) ||O(n<sup>2</sup>)||
|  28  |Word Search Ii|[LC](https://leetcode.com/problems/word-search-ii/) |[Java](./BackTracking/WordSearch2.java) ||O(n<sup>2</sup>)||
## Bit-Magic

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Longest Consecutive Run Of 1s In Binary|[BS](https://binarysearch.com/problems/Longest-Consecutive-Run-of-1s-in-Binary) [GFG](https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1) |[CPP](./Bit-Magic/GFG_LongestConsecutive1.cpp) [Java](./Bit-Magic/LongestConsecutivesRunOfOnesInBinary.java) |Easy|O(1)||
|  2  |Minimum Updates To Make Bitwise OR Equal To Target|[BS](https://binarysearch.com/problems/Minimum-Updates-to-Make-Bitwise-OR-Equal-to-Target) |[Java](./Bit-Magic/MinimumUpdatesToMakeBitwiseOrEqualToTarget.java) ||O(n)||
|  3  |Add Binary|[LC](https://leetcode.com/problems/add-binary/) |[CPP](./Bit-Magic/LC_67_AddBinary.cpp) [Java](./Bit-Magic/AddBinary.java) ||O(n)||
|  4  |Bit Difference 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1) |[CPP](./Bit-Magic/GFG_BitDiff.cpp) [Java](./Bit-Magic/BitDifference.java) |Basic|O(n)||
|  5  |Check Whether K Th Bit Is Set Or Not 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1) |[CPP](./Bit-Magic/GFG_BIT_Check_Kth_Bit.cpp) [Java](./Bit-Magic/CheckKthBit.java) |Easy|O(n)||
|  6  |Count Total Set Bits 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1) |[CPP](./Bit-Magic/GFG_CountTotalSetBits.cpp) [Java](./Bit-Magic/CountSetBitsInARange.java) |Medium|O(n)||
|  7  |Find Position Of Set Bit3706|[GFG](https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1) |[CPP](./Bit-Magic/GFG_FindPosOfSetBit.cpp) [Java](./Bit-Magic/OnlySetBit.java) |Basic|O(1)||
|  8  |Finding The Numbers0215|[GFG](https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1#) |[Java](./Bit-Magic/NonRepeatingNumbers.java) |Easy|O(n)||
|  9  |Geek And Function V|[GFG](https://practice.geeksforgeeks.org/problems/geek-and-function-v/0) |[Java](./Bit-Magic/GeekAndFunctionV.java) |Easy|O(n<sup>2</sup>)||
|  10  |Jump Game|[GFG](https://practice.geeksforgeeks.org/problems/jump-game/1/#) |[CPP](./Bit-Magic/GFG_JumpGame.cpp) |Medium|O(1)||
|  11  |Maximum Subset Xor|[GFG](https://practice.geeksforgeeks.org/problems/maximum-subset-xor/1/) |[Java](./Bit-Magic/MaximumSubsetXOR.java) |Hard|O(n<sup>2</sup>)||
|  12  |Maximum Xor After Operations|[LC](https://leetcode.com/problems/maximum-xor-after-operations/) |[Java](./Bit-Magic/MaximumXORAfterOperations.java) ||O(n)||
|  13  |Missing Number In Array1416|[GFG](https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1) |[CPP](./Bit-Magic/GFG_BIT_CheckMissingNumber.cpp) [Java](./Bit-Magic/FindMissingNumber.java) |Easy|O(n<sup>2</sup>)||
|  14  |Nth Natural Number|[GFG](https://practice.geeksforgeeks.org/problems/nth-natural-number/1#) |[CPP](./Bit-Magic/GFG_NthNaturalNum.cpp) [Java](./Bit-Magic/NthNaturalNumber.java) |Hard|O(1)||
|  15  |Number Of 1 Bits|[LC](https://leetcode.com/problems/number-of-1-bits/) |[CPP](./Bit-Magic/LC_191_NumberOfBits.cpp) [Java](./Bit-Magic/NoOfOneBits.java) ||O(1)||
|  16  |Number Of Excellent Pairs|[LC](https://leetcode.com/problems/number-of-excellent-pairs/submissions/) |[Java](./Bit-Magic/NumberOfExcellentPairs.java) ||O(n)||
|  17  |Permutation Sequence|[LC](https://leetcode.com/problems/permutation-sequence/) |[CPP](./Bit-Magic/LC_60_PermutationSeq.cpp) [Java](./Bit-Magic/PermutationSequence.java) ||O(n)||
|  18  |Power Of Two|[LC](https://leetcode.com/problems/power-of-two/) |[CPP](./Bit-Magic/LC_231_Power_of_two.cpp) [Java](./Bit-Magic/PowerOfTwo.java) ||O(1)||
|  19  |Reverse Bits|[LC](https://leetcode.com/problems/reverse-bits/) [GFG](https://practice.geeksforgeeks.org/problems/reverse-bits-1611130171/1/) |[CPP](./Bit-Magic/LC_190_GFG_ReverseBits.cpp) [Java](./Bit-Magic/ReverseBits.java) |Easy|O(1)||
|  20  |Single Number|[LC](https://leetcode.com/problems/single-number/) |[CPP](./Bit-Magic/LC_136_Bit_SingleNumber.cpp) [Java](./Bit-Magic/FindOddOccuringNumber.java) ||O(n)||
|  21  |Single Number Iii|[LC](https://leetcode.com/problems/single-number-iii/) |[CPP](./Bit-Magic/LC_260_SingleNumber_III.cpp) [Java](./Bit-Magic/TwoOddOccurringElements.java) ||O(1)||
|  22  |Sort By Set Bit Count1153|[GFG](https://practice.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1#) |[Java](./Bit-Magic/SortBySetBitCount.java) |Easy|O(n)||
|  23  |Sum Of Two Integers|[LC](https://leetcode.com/problems/sum-of-two-integers/) |[CPP](./Bit-Magic/LC_371_SumWithoutArithmeticOperatorsNegative.cpp) [Java](./Bit-Magic/SumWithoutArithmeticOperatorsNegative.java) ||O(1)||
|  24  |Sum Of Two Numbers Without Using Arithmetic Operators|[GFG](https://practice.geeksforgeeks.org/problems/sum-of-two-numbers-without-using-arithmetic-operators/1/#) |[CPP](./Bit-Magic/GFG_SumWithoutArithmeticOperators.cpp) [Java](./Bit-Magic/SumWithoutArithmeticOperators.java) |Easy|O(1)||
|  25  |Trailing Zeroes In Factorial5134|[GFG](https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1) |[CPP](./Bit-Magic/GFG_TrainlingZeroesInFactorial.cpp) [Java](./Bit-Magic/TrailingZeroes.java) |Easy|O(1)||
|  26  |Ugly Number|[LC](https://leetcode.com/problems/ugly-number/) |[CPP](./Bit-Magic/LC_263_UglyNumber.cpp) [Java](./Bit-Magic/UglyNumber.java) ||O(1)||
|  27  |Ugly Number Ii|[LC](https://leetcode.com/problems/ugly-number-ii/) |[CPP](./Bit-Magic/LC_264_UglyNumberII.cpp) [Java](./Bit-Magic/UglyNumber2.java) ||O(1)||
|  28  |X Xor A Is Minimum And Set Bits In X B|[GFG](https://practice.geeksforgeeks.org/problems/x-xor-a-is-minimum-and-set-bits-in-x-b/1) |[Java](./Bit-Magic/MinimumXXorA.java) |Hard|O(n)||
## Codeforces

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |112 A|[CF](https://codeforces.com/problemset/problem/112/A) |[Java](./Codeforces/PetyaAndStrings.java) ||O(n)||
|  2  |1141 B|[CF](https://codeforces.com/problemset/problem/1141/B) |[Java](./Codeforces/MaximalContinuousRest.java) ||O(n)||
|  3  |1144 B|[CF](https://codeforces.com/problemset/problem/1144/B) |[Java](./Codeforces/ParityAlternatedDeletions.java) ||O(n)||
|  4  |115 A|[CF](https://codeforces.com/problemset/problem/115/A) |[Java](./Codeforces/Party.java) ||O(n)||
|  5  |1208 A|[CF](https://codeforces.com/problemset/problem/1208/A) |[Java](./Codeforces/XORinacci.java) ||O(n)||
|  6  |1283 A|[CF](https://codeforces.com/problemset/problem/1283/A) |[Java](./Codeforces/MinutesBeforeNewYear.java) ||O(n)||
|  7  |129 A|[CF](https://codeforces.com/problemset/problem/129/A) |[Java](./Codeforces/Cookies.java) ||O(n)||
|  8  |1294 A|[CF](https://codeforces.com/problemset/problem/1294/A) |[Java](./Codeforces/CollectingCoins.java) ||O(n)||
|  9  |1296 B|[CF](https://codeforces.com/problemset/problem/1296/B) |[Java](./Codeforces/FoodBuying.java) ||O(n<sup>2</sup>)||
|  10  |1311 A|[CF](https://codeforces.com/problemset/problem/1311/A) |[Java](./Codeforces/AddOddOrSubtractEven.java) ||O(n)||
|  11  |1324 A|[CF](https://codeforces.com/problemset/problem/1324/A) |[Java](./Codeforces/YetAnotherTetrisProblem.java) ||O(n<sup>2</sup>)||
|  12  |1325 B|[CF](https://codeforces.com/problemset/problem/1325/B) |[Java](./Codeforces/CopyCopyCopyCopyCopy.java) ||O(n<sup>2</sup>)||
|  13  |1326 B|[CF](https://codeforces.com/problemset/problem/1326/B) |[Java](./Codeforces/Maximums.java) ||O(n)||
|  14  |1335 B|[CF](https://codeforces.com/problemset/problem/1335/B) |[Java](./Codeforces/ConstructTheString.java) ||O(n<sup>2</sup>)||
|  15  |1337 B|[CF](https://codeforces.com/problemset/problem/1337/B) |[Java](./Codeforces/KanaAndDragonQuestGame.java) ||O(n<sup>2</sup>)||
|  16  |1343 B|[CF](https://codeforces.com/problemset/problem/1343/B) |[Java](./Codeforces/BalancedArray.java) ||O(n<sup>2</sup>)||
|  17  |1350 A|[CF](https://codeforces.com/problemset/problem/1350/A) |[Java](./Codeforces/OracAndFactors.java) ||O(n<sup>2</sup>)||
|  18  |1353 B|[CF](https://codeforces.com/problemset/problem/1353/B) |[Java](./Codeforces/TwoArraysAndSwap.java) ||O(n<sup>2</sup>)||
|  19  |1367 B|[CF](https://codeforces.com/problemset/problem/1367/B) |[Java](./Codeforces/EvenArray.java) ||O(n<sup>2</sup>)||
|  20  |1368 A|[CF](https://codeforces.com/problemset/problem/1368/A) |[Java](./Codeforces/CPlusEqual.java) ||O(n<sup>2</sup>)||
|  21  |1370 A|[CF](https://codeforces.com/problemset/problem/1370/A) |[CPP](./Codeforces/A1370_MaximumGCD.cpp) [Java](./Codeforces/MaximumGCD.java) ||O(1)||
|  22  |1374 B|[CF](https://codeforces.com/problemset/problem/1374/B) |[Java](./Codeforces/MultiplyBy2DivideBy6.java) ||O(n)||
|  23  |1385 B|[CF](https://codeforces.com/problemset/problem/1385/B) |[Java](./Codeforces/RestoreThePermutationByMerger.java) ||O(n<sup>2</sup>)||
|  24  |1401 A|[CF](https://codeforces.com/problemset/problem/1401/A) |[Java](./Codeforces/DistanceAndAxis.java) ||O(n)||
|  25  |141 A|[CF](https://codeforces.com/problemset/problem/141/A) |[Java](./Codeforces/AmusingJoke.java) ||O(n)||
|  26  |1426 B|[CF](https://codeforces.com/problemset/problem/1426/B) |[Java](./Codeforces/SymmetricMatrix.java) ||O(n<sup>4</sup>)||
|  27  |1430 A|[CF](https://codeforces.com/problemset/problem/1430/A) |[Java](./Codeforces/NumberOfApartments.java) ||O(n)||
|  28  |1462 C|[CF](https://codeforces.com/problemset/problem/1462/C) |[Java](./Codeforces/UniqueNumber.java) ||O(n<sup>2</sup>)||
|  29  |1475 B|[CF](https://codeforces.com/problemset/problem/1475/B) |[Java](./Codeforces/NewYearsNumber.java) ||O(n)||
|  30  |148 A|[CF](https://codeforces.com/problemset/problem/148/A) |[Java](./Codeforces/InsomniaCure.java) ||O(n)||
|  31  |1525 B|[CF](https://codeforces.com/problemset/problem/1525/B) |[Java](./Codeforces/PermutationSort.java) ||O(n<sup>2</sup>)||
|  32  |1543 B|[CF](https://codeforces.com/problemset/problem/1543/B) |[Java](./Codeforces/CustomizingTheTrack.java) ||O(n<sup>2</sup>)||
|  33  |1559 B|[CF](https://codeforces.com/problemset/problem/1559/B) |[Java](./Codeforces/MochaAndRedAndBlue.java) ||O(n<sup>2</sup>)||
|  34  |1560 B|[CF](https://codeforces.com/problemset/problem/1560/B) |[Java](./Codeforces/WhoIsOpposite.java) ||O(n)||
|  35  |158 A|[CF](https://codeforces.com/problemset/problem/158/A) |[Java](./Codeforces/NextRound.java) ||O(1)||
|  36  |1607 H|[CF](https://codeforces.com/problemset/problem/1607/H) |[Java](./Codeforces/BanquetPreparation.java) ||O(n<sup>2</sup>)||
|  37  |1624 B|[CF](https://codeforces.com/problemset/problem/1624/B) |[Java](./Codeforces/MakeAP.java) ||O(n)||
|  38  |200 B|[CF](https://codeforces.com/problemset/problem/200/B) |[Java](./Codeforces/Drinks.java) ||O(n)||
|  39  |231 A|[CF](https://codeforces.com/problemset/problem/231/A) |[Java](./Codeforces/Team.java) ||O(n)||
|  40  |236 A|[CF](https://codeforces.com/problemset/problem/236/A) |[Java](./Codeforces/BoyOrGirl.java) ||O(n)||
|  41  |263 A|[CF](https://codeforces.com/problemset/problem/263/A) |[Java](./Codeforces/BeautifulMatrix.java) ||O(n<sup>2</sup>)||
|  42  |266 B|[CF](https://codeforces.com/problemset/problem/266/B) |[Java](./Codeforces/QueueAtSchool.java) ||O(n<sup>2</sup>)||
|  43  |282 A|[CF](https://codeforces.com/problemset/problem/282/A) |[Java](./Codeforces/BitParser.java) ||O(n)||
|  44  |318 A|[CF](https://codeforces.com/problemset/problem/318/A) |[Java](./Codeforces/EvenOdds.java) ||O(1)||
|  45  |32 B|[CF](https://codeforces.com/problemset/problem/32/B) |[Java](./Codeforces/Borze.java) ||O(n)||
|  46  |320 A|[CF](https://codeforces.com/problemset/problem/320/A) |[Java](./Codeforces/MagicNumbers.java) ||O(n)||
|  47  |339 A|[CF](https://codeforces.com/problemset/problem/339/A) |[Java](./Codeforces/HelpfulMaths.java) ||O(n)||
|  48  |34 B|[CF](https://codeforces.com/problemset/problem/34/B) |[Java](./Codeforces/Sale.java) ||O(n)||
|  49  |4 A|[CF](https://codeforces.com/problemset/problem/4/A) |[Java](./Codeforces/Watermelon.java) ||O(1)||
|  50  |41 A|[CF](https://codeforces.com/problemset/problem/41/A) |[Java](./Codeforces/Translation.java) ||O(n)||
|  51  |432 A|[CF](https://codeforces.com/problemset/problem/432/A) |[Java](./Codeforces/ChoosingTeams.java) ||O(n)||
|  52  |439 A|[CF](https://codeforces.com/problemset/problem/439/A) |[Java](./Codeforces/DevuTheSingerAndChuruTheJoker.java) ||O(n)||
|  53  |443 A|[CF](https://codeforces.com/problemset/problem/443/A) |[Java](./Codeforces/AntonAndLetters.java) ||O(n)||
|  54  |469 A|[CF](https://codeforces.com/problemset/problem/469/A) |[Java](./Codeforces/IWannaBeTheGuy.java) ||O(n)||
|  55  |474 A|[CF](https://codeforces.com/problemset/problem/474/A) |[Java](./Codeforces/Keyboard.java) ||O(n)||
|  56  |490 A|[CF](https://codeforces.com/problemset/problem/490/A) |[Java](./Codeforces/TeamOlympiad.java) ||O(n)||
|  57  |496 A|[CF](https://codeforces.com/problemset/problem/496/A) |[Java](./Codeforces/MinimumDifficulty.java) ||O(n)||
|  58  |50 A|[CF](https://codeforces.com/problemset/problem/50/A) |[Java](./Codeforces/DominoPiling.java) ||O(1)||
|  59  |546 A|[CF](https://codeforces.com/problemset/problem/546/A) |[Java](./Codeforces/SoldierAndBananas.java) ||O(1)||
|  60  |580 A|[CF](https://codeforces.com/problemset/problem/580/A) |[Java](./Codeforces/KefaAndFirstSteps.java) ||O(n)||
|  61  |59 A|[CF](https://codeforces.com/problemset/problem/59/A) |[Java](./Codeforces/Word.java) ||O(n)||
|  62  |617 A|[CF](https://codeforces.com/problemset/problem/617/A) |[Java](./Codeforces/Elephant.java) ||O(1)||
|  63  |677 A|[CF](https://codeforces.com/problemset/problem/677/A) |[Java](./Codeforces/VanyaAndFence.java) ||O(n)||
|  64  |702 A|[CF](https://codeforces.com/problemset/problem/702/A) |[Java](./Codeforces/MaximumIncrease.java) ||O(n)||
|  65  |709 A|[CF](https://codeforces.com/problemset/problem/709/A) |[Java](./Codeforces/Juicer.java) ||O(n)||
|  66  |71 A|[CF](https://codeforces.com/problemset/problem/71/A) |[Java](./Codeforces/WayTooLongWords.java) ||O(n)||
|  67  |711 A|[CF](https://codeforces.com/problemset/problem/711/A) |[Java](./Codeforces/BusToUdayLand.java) ||O(n)||
|  68  |732 A|[CF](https://codeforces.com/problemset/problem/732/A) |[Java](./Codeforces/BuyAShovel.java) ||O(1)||
|  69  |746 B|[CF](https://codeforces.com/problemset/problem/746/B) |[Java](./Codeforces/Decoding.java) ||O(n)||
|  70  |749 A|[CF](https://codeforces.com/problemset/problem/749/A) |[Java](./Codeforces/BachGoldProblem.java) ||O(n)||
|  71  |750 A|[CF](https://codeforces.com/problemset/problem/750/A) |[Java](./Codeforces/NewYearAndHurry.java) ||O(n)||
|  72  |768 A|[CF](https://codeforces.com/problemset/problem/768/A) |[Java](./Codeforces/OathOfTheNightsWatch.java) ||O(n)||
|  73  |977 B|[CF](https://codeforces.com/problemset/problem/977/B) |[Java](./Codeforces/TwoGram.java) ||O(n)||
|  74  |978 B|[CF](https://codeforces.com/problemset/problem/978/B) |[Java](./Codeforces/FileName.java) ||O(n)||
|  75  |991 B|[CF](https://codeforces.com/problemset/problem/991/B) |[Java](./Codeforces/GettingAnA.java) ||O(n)||
|  76  |999 B|[CF](https://codeforces.com/problemset/problem/999/B) |[Java](./Codeforces/ReversingEncryption.java) ||O(n)||
## Disjoint-Set

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Accounts Merge|[LC](https://leetcode.com/problems/accounts-merge/) |[Java](./Disjoint-Set/AccountsMerge.java) ||O(n)||
|  2  |Number Of Operations To Make Network Connected|[LC](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) |[Java](./Disjoint-Set/ConnectNetwork.java) ||O(n)||
|  3  |Number Of Provinces|[LC](https://leetcode.com/problems/number-of-provinces/) [GFG](https://practice.geeksforgeeks.org/problems/number-of-provinces/1) |[Java](./Disjoint-Set/NumberOfProvinces.java) |Medium|O(n<sup>3</sup>)||
|  4  |Redundant Connection|[LC](https://leetcode.com/problems/redundant-connection/) |[Java](./Disjoint-Set/RedundantConnection.java) ||O(n)||
## Dynamic-Programming

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |0 1 Knapsack Problem0945|[GFG](https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1) |[CPP](./Dynamic-Programming/GFG_01Knapsack.cpp) [Java](./Dynamic-Programming/BinaryKnapsack.java) |Medium|O(n<sup>2</sup>)||
|  2  |Collecting Coins|[BS](https://binarysearch.com/problems/Collecting-Coins) |[Java](./Dynamic-Programming/CollectingCoins.java) ||O(n)||
|  3  |Count Square Submatrices|[BS](https://binarysearch.com/problems/Count-Square-Submatrices) |[Java](./Dynamic-Programming/CountSquareSubmatrices.java) ||O(n<sup>2</sup>)||
|  4  |Delete Characters To Equalize Strings|[BS](https://binarysearch.com/problems/Delete-Characters-to-Equalize-Strings) |[Java](./Dynamic-Programming/DeleteCharactersToEqualizeStrings.java) ||O(n<sup>2</sup>)||
|  5  |Equal Partitions|[BS](https://binarysearch.com/problems/Equal-Partitions) [LC](https://leetcode.com/problems/partition-equal-subset-sum/) |[Java](./Dynamic-Programming/PartitionEqualSubsetSum.java) ||O(n)||
|  6  |Largest Sum Of Non Adjacent Numbers|[BS](https://binarysearch.com/problems/Largest-Sum-of-Non-Adjacent-Numbers) |[Java](./Dynamic-Programming/LargestSumOfNonAdjacentNumbers.java) ||O(n)||
|  7  |Longest Bitonic Subsequence|[BS](https://binarysearch.com/problems/Longest-Bitonic-Subsequence) |[Java](./Dynamic-Programming/LongestBitonicSubsequence.java) ||O(n)||
|  8  |Longest Common Substring|[BS](https://binarysearch.com/problems/Longest-Common-Substring) [GFG](https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1) |[Java](./Dynamic-Programming/LongestCommonSubstring.java) |Medium|O(n)||
|  9  |Longest Increasing Subsequence|[BS](https://binarysearch.com/problems/Longest-Increasing-Subsequence) [GFG](https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1) |[Java](./Dynamic-Programming/LongestIncreasingSubsequence.java) |Medium|O(n<sup>2</sup>)||
|  10  |Longest Sign Alternating Subsequence|[BS](https://binarysearch.com/problems/Longest-Sign-Alternating-Subsequence) |[Java](./Dynamic-Programming/LongestSignAlternatingSequence.java) ||O(n<sup>2</sup>)||
|  11  |Multiset Sum|[BS](https://binarysearch.com/problems/Multiset-Sum) |[Java](./Dynamic-Programming/MultisetSum.java) ||O(n)||
|  12  |Palindrome Splitting|[BS](https://binarysearch.com/problems/Palindrome-Splitting) |[Java](./Dynamic-Programming/PalindromeSplitting.java) ||O(n)||
|  13  |Rod Cutting|[BS](https://binarysearch.com/problems/Rod-Cutting) |[Java](./Dynamic-Programming/RodCutting.java) ||O(n)||
|  14  |Skip Tasks To Minimize Work|[BS](https://binarysearch.com/problems/Skip-Tasks-to-Minimize-Work) |[Java](./Dynamic-Programming/SkipTasksToMinimizeWork.java) ||O(n)||
|  15  |All Possible Full Binary Trees|[LC](https://leetcode.com/problems/all-possible-full-binary-trees/) |[Java](./Dynamic-Programming/AllPossibleFullBinaryTrees.java) ||O(n<sup>2</sup>)||
|  16  |Arithmetic Slices|[LC](https://leetcode.com/problems/arithmetic-slices/) |[CPP](./Dynamic-Programming/LC_413_ArithmeticSlices.cpp) [Java](./Dynamic-Programming/ArithmeticSlices.java) ||O(n<sup>2</sup>)||
|  17  |Bbt Counter4914|[GFG](https://practice.geeksforgeeks.org/problems/bbt-counter4914/1) |[CPP](./Dynamic-Programming/GFG_bbtCounter.cpp) [Java](./Dynamic-Programming/BBTCounter.java) |Easy|O(n)||
|  18  |Beautiful Arrangement|[LC](https://leetcode.com/problems/beautiful-arrangement/solution/) |[Java](./Dynamic-Programming/BeautifulArrangement.java) ||O(n)||
|  19  |Best Time To Buy And Sell Stock Iv|[LC](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) [GFG](https://practice.geeksforgeeks.org/problems/maximum-profit4657/1) |[Java](./Dynamic-Programming/BestTimeToBuyAndSellStock4.java) |Hard|O(n<sup>2</sup>)||
|  20  |Box Stacking|[GFG](https://practice.geeksforgeeks.org/problems/box-stacking/1/) |[Java](./Dynamic-Programming/BoxStacking.java) |Medium|O(n<sup>2</sup>)||
|  21  |Brackets In Matrix Chain Multiplication1024|[GFG](https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1) |[Java](./Dynamic-Programming/BracketsInMatrixChainMultiplication.java) |Hard|O(n)||
|  22  |Cherry Pickup Ii|[LC](https://leetcode.com/problems/cherry-pickup-ii/) |[Java](./Dynamic-Programming/CherryPickup2.java) ||O(n<sup>5</sup>)||
|  23  |Climbing Stairs|[LC](https://leetcode.com/problems/climbing-stairs/) [GFG](https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1) |[Java](./Dynamic-Programming/CountWaysToNthStair.java) |Medium|O(n)||
|  24  |Coin Change|[LC](https://leetcode.com/problems/coin-change/) [GFG](https://practice.geeksforgeeks.org/problems/coin-change2448/1/) |[Java](./Dynamic-Programming/CoinChange.java) |Medium|O(n<sup>2</sup>)||
|  25  |Count Digit Groupings Of A Number1520|[GFG](https://practice.geeksforgeeks.org/problems/count-digit-groupings-of-a-number1520/1/) |[Java](./Dynamic-Programming/CountDigitGroupingsOfANumber.java) |Medium|O(n)||
|  26  |Count Number Of Teams|[LC](https://leetcode.com/problems/count-number-of-teams/) |[Java](./Dynamic-Programming/CountNumberOfTeams.java) ||O(n<sup>3</sup>)||
|  27  |Count Number Of Ways To Place Houses|[LC](https://leetcode.com/problems/count-number-of-ways-to-place-houses/) |[Java](./Dynamic-Programming/CountNumberOfWaysToPlaceHouses.java) ||O(n)||
|  28  |Count Numbers With Unique Digits|[LC](https://leetcode.com/problems/count-numbers-with-unique-digits/) |[Java](./Dynamic-Programming/CountNumbersWithUniqueDigits.java) ||O(n<sup>2</sup>)||
|  29  |Count Palindromic Subsequences|[GFG](https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1) |[Java](./Dynamic-Programming/CountLongestPalindromicSubsequences.java) |Medium|O(n<sup>2</sup>)||
|  30  |Count Primes|[LC](https://leetcode.com/problems/count-primes/) |[Java](./Dynamic-Programming/CountPrimes.java) ||O(n<sup>2</sup>)||
|  31  |Count Sorted Vowel Strings|[LC](https://leetcode.com/problems/count-sorted-vowel-strings/) |[Java](./Dynamic-Programming/CountSortedVowelStrings.java) ||O(n<sup>2</sup>)||
|  32  |Count Square Submatrices With All Ones|[LC](https://leetcode.com/problems/count-square-submatrices-with-all-ones/) |[CPP](./Dynamic-Programming/LC_1277_CountSquareSubmatricesAllOnes.cpp) [Java](./Dynamic-Programming/CountCompleteSquaresInMatrix.java) ||O(n<sup>2</sup>)||
|  33  |Counting Bits|[LC](https://leetcode.com/problems/counting-bits/) |[CPP](./Dynamic-Programming/LC_338_CountingBits.cpp) [Java](./Dynamic-Programming/CountBitsInEachNumber.java) ||O(n<sup>2</sup>)||
|  34  |Cutted Segments1642|[GFG](https://practice.geeksforgeeks.org/problems/cutted-segments1642/1/) |[Java](./Dynamic-Programming/MaximizeCuts.java) |Medium|O(n)||
|  35  |Decode Ways|[LC](https://leetcode.com/problems/decode-ways/) |[Java](./Dynamic-Programming/DecodeWays.java) ||O(n)||
|  36  |Different Ways To Add Parentheses|[LC](https://leetcode.com/problems/different-ways-to-add-parentheses/) |[Java](./Dynamic-Programming/DifferentWaysToAddParentheses.java) ||O(n<sup>3</sup>)||
|  37  |Distinct Subsequences|[LC](https://leetcode.com/problems/distinct-subsequences/) |[Java](./Dynamic-Programming/DistinctSubsequences.java) ||O(n)||
|  38  |Edit Distance3702|[GFG](https://practice.geeksforgeeks.org/problems/edit-distance3702/1) |[Java](./Dynamic-Programming/EditDistance.java) |Medium|O(n<sup>2</sup>)||
|  39  |Friends Pairing Problem5425|[GFG](https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1/) |[Java](./Dynamic-Programming/FriendsPairing.java) |Easy|O(n)||
|  40  |Get Maximum In Generated Array|[LC](https://leetcode.com/problems/get-maximum-in-generated-array/) |[Java](./Dynamic-Programming/GetMaximumInGeneratedArray.java) ||O(n)||
|  41  |Get Minimum Squares0538|[GFG](https://practice.geeksforgeeks.org/problems/get-minimum-squares0538/1) |[Java](./Dynamic-Programming/MinimumSquaresSum.java) |Medium|O(n<sup>2</sup>)||
|  42  |Gold Mine Problem2608|[GFG](https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1/) |[Java](./Dynamic-Programming/GoldMine.java) |Easy|O(n<sup>2</sup>)||
|  43  |House Robber|[LC](https://leetcode.com/problems/house-robber/) |[CPP](./Dynamic-Programming/LC_198_HouseRobber.cpp) [Java](./Dynamic-Programming/HouseRobber.java) ||O(n)||
|  44  |House Robber Ii|[LC](https://leetcode.com/problems/house-robber-ii/) |[Java](./Dynamic-Programming/HouseRobber2.java) ||O(n)||
|  45  |House Robber Iii|[LC](https://leetcode.com/problems/house-robber-iii/) [GFG](https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1/) |[Java](./Dynamic-Programming/HouseRobber3.java) |Medium|O(1)||
|  46  |Integer Break|[LC](https://leetcode.com/problems/integer-break/) |[Java](./Dynamic-Programming/IntegerBreak.java) ||O(n<sup>2</sup>)||
|  47  |Integer Replacement|[LC](https://leetcode.com/problems/integer-replacement/) |[Java](./Dynamic-Programming/IntegerReplacement.java) ||O(n)||
|  48  |Interleaving String|[LC](https://leetcode.com/problems/interleaving-string/) |[Java](./Dynamic-Programming/InterleavingString.java) ||O(n<sup>2</sup>)||
|  49  |Intersecting Intervals|[GFG](https://practice.geeksforgeeks.org/problems/intersecting-intervals/1/) |[Java](./Dynamic-Programming/MaximumNumberOfOverlappingIntervals.java) |Hard|O(n)||
|  50  |Is Subsequence|[LC](https://leetcode.com/problems/is-subsequence/) |[Java](./Dynamic-Programming/IsSubsequence.java) ||O(n)||
|  51  |K Palindrome|[GFG](https://practice.geeksforgeeks.org/problems/k-palindrome/1) |[Java](./Dynamic-Programming/KPalindrome.java) |Easy|O(n<sup>2</sup>)||
|  52  |Knapsack With Duplicate Items4201|[GFG](https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#) |[CPP](./Dynamic-Programming/GFG_01KnapsackDuplicateItems.cpp) [Java](./Dynamic-Programming/UnboundedKnapsack.java) |Easy|O(1)||
|  53  |Largest Divisible Subset|[LC](https://leetcode.com/problems/largest-divisible-subset/) |[Java](./Dynamic-Programming/LargestDivisibleSubset.java) ||O(n<sup>2</sup>)||
|  54  |Largest Square Formed In A Matrix0806|[GFG](https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1) |[Java](./Dynamic-Programming/MaxSquareOfOnes.java) |Medium|O(n)||
|  55  |Lcs Of Three Strings0028|[GFG](https://practice.geeksforgeeks.org/problems/lcs-of-three-strings0028/1#) |[CPP](./Dynamic-Programming/GFG_LCS3.cpp) [Java](./Dynamic-Programming/LCS3.java) |Medium|O(1)||
|  56  |Longest Arithmetic Subsequence Of Given Difference|[LC](https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/) |[Java](./Dynamic-Programming/LongestArithmeticSubsequenceOfGivenDifference.java) ||O(n)||
|  57  |Longest Common Subsequence|[LC](https://leetcode.com/problems/longest-common-subsequence/) [GFG](https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1) |[Java](./Dynamic-Programming/LCS.java) |Medium|O(n<sup>3</sup>)||
|  58  |Longest Common Subsequence 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1) |[CPP](./Dynamic-Programming/GFG_LCS.cpp) |Medium|O(1)||
|  59  |Longest Common Substring1452|[GFG](https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1#) |[CPP](./Dynamic-Programming/GFG_LongestCommonSubstring.cpp) |Medium|O(1)||
|  60  |Longest Continuous Increasing Subsequence|[LC](https://leetcode.com/problems/longest-continuous-increasing-subsequence/) |[Java](./Dynamic-Programming/LongestContinuousIncreasingSubsequence.java) ||O(n)||
|  61  |Longest Increasing Path In A Matrix|[LC](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) |[Java](./Dynamic-Programming/LongestIncreasingPathInAMatrix.java) ||O(n)||
|  62  |Longest Palindromic Subsequence 1612327878|[GFG](https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1) |[Java](./Dynamic-Programming/LongestPalindromicSubsequence.java) |Medium|O(n<sup>2</sup>)||
|  63  |Longest Palindromic Substring|[LC](https://leetcode.com/problems/longest-palindromic-substring/) |[Java](./Dynamic-Programming/LongestPalindromicSubstring.java) ||O(n)||
|  64  |Longest Repeating Subsequence2004|[GFG](https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1) |[Java](./Dynamic-Programming/LongestRepeatingSubsequence.java) |Easy|O(n<sup>2</sup>)||
|  65  |Matrix Block Sum|[LC](https://leetcode.com/problems/matrix-block-sum/) |[Java](./Dynamic-Programming/MatrixBlockSum.java) ||O(n<sup>3</sup>)||
|  66  |Matrix Chain Multiplication0303|[GFG](https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1) |[Java](./Dynamic-Programming/MatrixChainMultiplication.java) |Hard|O(n<sup>3</sup>)||
|  67  |Maximum Length Of Repeated Subarray|[LC](https://leetcode.com/problems/maximum-length-of-repeated-subarray/) |[Java](./Dynamic-Programming/MaxLengthRepeatedSubarray.java) ||O(n<sup>2</sup>)||
|  68  |Maximum Profit In Job Scheduling|[LC](https://leetcode.com/problems/maximum-profit-in-job-scheduling/) |[Java](./Dynamic-Programming/WeightedIntervalScheduling.java) ||O(n<sup>2</sup>)||
|  69  |Maximum Score Words Formed By Letters|[LC](https://leetcode.com/problems/maximum-score-words-formed-by-letters/) |[Java](./Dynamic-Programming/MaximumScoreWordFormedByLetters.java) ||O(n<sup>2</sup>)||
|  70  |Maximum Sum Increasing Subsequence4749|[GFG](https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1) |[Java](./Dynamic-Programming/MaximumSumIncreasingSubsequence.java) |Medium|O(n<sup>2</sup>)||
|  71  |Maximum Sum Of Elements Not Part Of Lis|[GFG](https://practice.geeksforgeeks.org/problems/maximum-sum-of-elements-not-part-of-lis/1) |[Java](./Dynamic-Programming/MaxSumNotPartOfLIS.java) |Medium|O(n<sup>2</sup>)||
|  72  |Min Cost Climbing Stairs|[LC](https://leetcode.com/problems/min-cost-climbing-stairs/) |[Java](./Dynamic-Programming/MinCostStairs.java) ||O(n)||
|  73  |Minimize The Difference Between Target And Chosen Elements|[LC](https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/) |[Java](./Dynamic-Programming/MinimizeTheDifferenceBetweenTargetAndChosenElements.java) ||O(n<sup>3</sup>)||
|  74  |Minimum Ascii Delete Sum For Two Strings|[LC](https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/) |[Java](./Dynamic-Programming/MinimumASCIIDeleteSumForTwoStrings.java) ||O(n<sup>2</sup>)||
|  75  |Minimum Cost For Tickets|[LC](https://leetcode.com/problems/minimum-cost-for-tickets/) |[Java](./Dynamic-Programming/MinimumCostForTickets.java) ||O(n<sup>2</sup>)||
|  76  |Minimum Cost To Fill Given Weight In A Bag1956|[GFG](https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1) |[CPP](./Dynamic-Programming/GFG_MinCostToFillGivenWeightInABag.cpp) [Java](./Dynamic-Programming/BuyOranges.java) |Medium|O(n<sup>2</sup>)||
|  77  |Minimum Cost Tree From Leaf Values|[LC](https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/) |[Java](./Dynamic-Programming/MinimumCostTreeFromLeafValues.java) ||O(n<sup>2</sup>)||
|  78  |Minimum Falling Path Sum|[LC](https://leetcode.com/problems/minimum-falling-path-sum/) |[CPP](./Dynamic-Programming/LC_931_MinFallingPathSum.cpp) [Java](./Dynamic-Programming/MinimumFallingPathSum.java) ||O(1)||
|  79  |Minimum Falling Path Sum Ii|[LC](https://leetcode.com/problems/minimum-falling-path-sum-ii/) |[Java](./Dynamic-Programming/MinimumFallingPathSum2.java) ||O(n)||
|  80  |Minimum Path Cost In A Grid|[LC](https://leetcode.com/problems/minimum-path-cost-in-a-grid/) |[Java](./Dynamic-Programming/MinimumPathCostInAGrid.java) ||O(n<sup>2</sup>)||
|  81  |Minimum Path Sum|[LC](https://leetcode.com/problems/minimum-path-sum/submissions/) |[CPP](./Dynamic-Programming/LC_64_MinPathSum.cpp) [Java](./Dynamic-Programming/MinimumPathSum.java) ||O(1)||
|  82  |Minimum Sum Partition3317|[GFG](https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/) |[Java](./Dynamic-Programming/MinimumSumPartition.java) |Hard|O(n<sup>2</sup>)||
|  83  |N Th Tribonacci Number|[LC](https://leetcode.com/problems/n-th-tribonacci-number/) |[Java](./Dynamic-Programming/NthTribonacci.java) ||O(n)||
|  84  |Ncr1019|[GFG](https://practice.geeksforgeeks.org/problems/ncr1019/1) |[Java](./Dynamic-Programming/BinomialCoefficients.java) |Medium|O(n<sup>2</sup>)||
|  85  |Nth Catalan Number0817|[GFG](https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1/) |[Java](./Dynamic-Programming/CatalanNumbers.java) |Easy|O(n<sup>2</sup>)||
|  86  |Number Of Coins1824|[GFG](https://practice.geeksforgeeks.org/problems/number-of-coins1824/1) |[Java](./Dynamic-Programming/MinimumCoins.java) |Medium|O(n<sup>2</sup>)||
|  87  |Number Of Distinct Roll Sequences|[LC](https://leetcode.com/problems/number-of-distinct-roll-sequences/) |[Java](./Dynamic-Programming/NumberOfDistinctRollSequences.java) ||O(n)||
|  88  |Number Of Longest Increasing Subsequence|[LC](https://leetcode.com/problems/number-of-longest-increasing-subsequence/) |[Java](./Dynamic-Programming/NumberOfLongestIncreasingSubsequences.java) ||O(n<sup>2</sup>)||
|  89  |Number Of Paths In A Matrix With K Coins2728|[GFG](https://practice.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins2728/1) |[Java](./Dynamic-Programming/NumberOfPathsInAMatrixWithKCoins.java) |null|O(1)||
|  90  |Number Of People Aware Of A Secret|[LC](https://leetcode.com/problems/number-of-people-aware-of-a-secret/) |[Java](./Dynamic-Programming/NumberOfPeopleAwareOfASecret.java) ||O(n)||
|  91  |Number Of Ways2552|[GFG](https://practice.geeksforgeeks.org/problems/number-of-ways2552/1) |[Java](./Dynamic-Programming/NumberOfWays.java) |Medium|O(n)||
|  92  |Ones And Zeroes|[LC](https://leetcode.com/problems/ones-and-zeroes/) |[Java](./Dynamic-Programming/OnesAndZeros.java) ||O(n<sup>2</sup>)||
|  93  |Paint House Iii|[LC](https://leetcode.com/problems/paint-house-iii/) |[Java](./Dynamic-Programming/PaintHouse3.java) ||O(n)||
|  94  |Painting The Fence3727|[GFG](https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1/) |[Java](./Dynamic-Programming/PaintTheFence.java) |Medium|O(n)||
|  95  |Palindromic Substrings|[LC](https://leetcode.com/problems/palindromic-substrings/) |[Java](./Dynamic-Programming/PalindromicSubstrings.java) ||O(n<sup>2</sup>)||
|  96  |Partition Array For Maximum Sum|[LC](https://leetcode.com/problems/partition-array-for-maximum-sum/) |[Java](./Dynamic-Programming/PartitionArrayForMaximumSum.java) ||O(n<sup>2</sup>)||
|  97  |Partition To K Equal Sum Subsets|[LC](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/) |[Java](./Dynamic-Programming/PartitionToKEqualSumSubsets.java) ||O(n)||
|  98  |Path In Matrix3805|[GFG](https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1) |[Java](./Dynamic-Programming/MaxPathSum.java) |Medium|O(n<sup>2</sup>)||
|  99  |Perfect Squares|[LC](https://leetcode.com/problems/perfect-squares/) |[Java](./Dynamic-Programming/PerfectSquare.java) ||O(n<sup>2</sup>)||
|  100  |Perfect Sum Problem5633|[GFG](https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1/) |[Java](./Dynamic-Programming/PerfectSumProblem.java) |Medium|O(1)||
|  101  |Predict The Winner|[LC](https://leetcode.com/problems/predict-the-winner/) |[Java](./Dynamic-Programming/PredictTheWinner.java) ||O(1)||
|  102  |Print All Lcs Sequences3413|[GFG](https://practice.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1/) |[Java](./Dynamic-Programming/PrintAllLCSSequences.java) |Hard|O(n<sup>2</sup>)||
|  103  |Reach A Given Score 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1) |[Java](./Dynamic-Programming/ReachAGivenScore.java) |Easy|O(n)||
|  104  |Regular Expression Matching|[LC](https://leetcode.com/problems/regular-expression-matching/) |[Java](./Dynamic-Programming/RegularExpressionMatching.java) ||O(1)||
|  105  |Rotate Function|[LC](https://leetcode.com/problems/rotate-function/) |[Java](./Dynamic-Programming/RotateFunction.java) ||O(n)||
|  106  |Scramble String|[LC](https://leetcode.com/problems/scramble-string/) |[Java](./Dynamic-Programming/ScrambleString.java) ||O(n)||
|  107  |Shortest Common Supersequence0322|[GFG](https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1/) |[Java](./Dynamic-Programming/ShortestCommonSupersequence.java) |Medium|O(n<sup>2</sup>)||
|  108  |Sort Integers By The Power Value|[LC](https://leetcode.com/problems/sort-integers-by-the-power-value/) |[Java](./Dynamic-Programming/SortIntegersByThePowerValue.java) ||O(n)||
|  109  |Special Keyboard3018|[GFG](https://practice.geeksforgeeks.org/problems/special-keyboard3018/1) |[Java](./Dynamic-Programming/SpecialKeyboard.java) |Medium|O(n<sup>2</sup>)||
|  110  |Stickler Theif 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1/) |[Java](./Dynamic-Programming/SticklerThief.java) |Easy|O(n<sup>2</sup>)||
|  111  |Subset Sum Problem 1611555638|[GFG](https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1) |[CPP](./Dynamic-Programming/GFG_SubsetSum.cpp) [Java](./Dynamic-Programming/SubsetSum.java) |Medium|O(1)||
|  112  |Subset Sum Problem2014|[GFG](https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1) |[Java](./Dynamic-Programming/PartitionArray.java) |Medium|O(n)||
|  113  |Sum Of Floored Pairs|[LC](https://leetcode.com/problems/sum-of-floored-pairs/) |[Java](./Dynamic-Programming/SumOfFlooredPairs.java) ||O(n<sup>3</sup>)||
|  114  |Super Egg Drop|[LC](https://leetcode.com/problems/super-egg-drop/) [GFG](https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1) |[Java](./Dynamic-Programming/EggDrop.java) |Medium|O(n<sup>3</sup>)||
|  115  |Super Ugly Number|[LC](https://leetcode.com/problems/super-ugly-number/) |[Java](./Dynamic-Programming/SuperUglyNumber.java) ||O(n<sup>2</sup>)||
|  116  |Target Sum|[LC](https://leetcode.com/problems/target-sum/) [GFG](https://practice.geeksforgeeks.org/problems/target-sum-1626326450/1) |[Java](./Dynamic-Programming/TargetSum.java) |Medium|O(n<sup>2</sup>)||
|  117  |Triangle|[LC](https://leetcode.com/problems/triangle/) |[Java](./Dynamic-Programming/Triangle.java) ||O(n)||
|  118  |Unique Paths|[LC](https://leetcode.com/problems/unique-paths/) |[Java](./Dynamic-Programming/UniquePaths.java) ||O(n<sup>2</sup>)||
|  119  |Unique Paths Ii|[LC](https://leetcode.com/problems/unique-paths-ii/) |[Java](./Dynamic-Programming/UniquePathsWithObstacles.java) ||O(n<sup>2</sup>)||
|  120  |Wiggle Subsequence|[LC](https://leetcode.com/problems/wiggle-subsequence/) |[CPP](./Dynamic-Programming/LC_376_WiggleSubsequence.cpp) [Java](./Dynamic-Programming/WiggleSubsequence.java) ||O(1)||
|  121  |Wildcard Pattern Matching|[GFG](https://practice.geeksforgeeks.org/problems/wildcard-pattern-matching/1) |[Java](./Dynamic-Programming/WildcardMatching.java) |Medium|O(n<sup>2</sup>)||
|  122  |Wildcard String Matching1126|[GFG](https://practice.geeksforgeeks.org/problems/wildcard-string-matching1126/1) |[Java](./Dynamic-Programming/WildCardStringMatching.java) |Hard|O(n)||
|  123  |Word Break1352|[GFG](https://practice.geeksforgeeks.org/problems/word-break1352/1) |[Java](./Dynamic-Programming/WordBreak.java) |Medium|O(n<sup>2</sup>)||
|  124  |Word Wrap1646|[GFG](https://practice.geeksforgeeks.org/problems/word-wrap1646/1) |[Java](./Dynamic-Programming/WordWrap.java) |Hard|O(n)||
## Graph

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |269f61832b146dd5e6d89b4ca18cbd2a2654ebbe|[GFG](https://practice.geeksforgeeks.org/problems/269f61832b146dd5e6d89b4ca18cbd2a2654ebbe/1/) |[Java](./Graph/CovidSpread.java) |Medium|O(n<sup>2</sup>)||
|  2  |Number Of Islands|[BS](https://binarysearch.com/problems/Number-of-Islands) [GFG](https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1) |[Java](./Graph/NumberOfIslands.java) |Medium|O(n)||
|  3  |Reverse Graph|[BS](https://binarysearch.com/problems/Reverse-Graph) |[Java](./Graph/ReverseGraph.java) ||O(n<sup>2</sup>)||
|  4  |Unlock Rooms|[BS](https://binarysearch.com/problems/Unlock-Rooms) |[CPP](./Graph/BS_UnlockRooms.cpp) [Java](./Graph/UnlockRooms.java) ||O(1)||
|  5  |Accounts Merge|[LC](https://leetcode.com/problems/accounts-merge/) |[Java](./Graph/AccountsMerge.java) ||O(n)||
|  6  |All Paths From Source To Target|[LC](https://leetcode.com/problems/all-paths-from-source-to-target/) |[Java](./Graph/AllPathsFromSourceToTarget.java) ||O(n)||
|  7  |Articulation Point 1|[GFG](https://practice.geeksforgeeks.org/problems/articulation-point-1/0/) |[Java](./Graph/ArticulationPoints1.java) |Hard|O(n)||
|  8  |As Far From Land As Possible|[LC](https://leetcode.com/problems/as-far-from-land-as-possible/) |[Java](./Graph/AsFarFromLandAsPossible.java) ||O(n<sup>2</sup>)||
|  9  |Bfs Traversal Of Graph|[GFG](https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1) |[CPP](./Graph/GFG_Graph_BFSTraversal.cpp) [Java](./Graph/BFS.java) |Easy|O(n<sup>2</sup>)||
|  10  |Bridge Edge In Graph|[GFG](https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1#) |[Java](./Graph/CheckIfBridge.java) |Medium|O(n)||
|  11  |Cheapest Flights Within K Stops|[LC](https://leetcode.com/problems/cheapest-flights-within-k-stops/) |[Java](./Graph/CheapestFlightWithinKStops.java) ||O(n<sup>2</sup>)||
|  12  |Circle Of Strings4530|[GFG](https://practice.geeksforgeeks.org/problems/circle-of-strings4530/1) |[Java](./Graph/CircleOfStrings.java) |Medium|O(n)||
|  13  |Clone Graph|[LC](https://leetcode.com/problems/clone-graph/) |[CPP](./Graph/LC_133_Graph_CloneGraph.cpp) [Java](./Graph/CloneGraph.java) ||O(n<sup>2</sup>)||
|  14  |Coloring A Border|[LC](https://leetcode.com/problems/coloring-a-border/) |[Java](./Graph/ColoringABorder.java) ||O(n)||
|  15  |Count Unreachable Pairs Of Nodes In An Undirected Graph|[LC](https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/) |[Java](./Graph/CountUnreachablePairsOfNodesInAnUndirectedGraph.java) ||O(n)||
|  16  |Course Schedule|[LC](https://leetcode.com/problems/course-schedule/) |[CPP](./Graph/LC_207_CourseSchedule.cpp) [Java](./Graph/CourseSchedule.java) ||O(n<sup>3</sup>)||
|  17  |Course Schedule Ii|[LC](https://leetcode.com/problems/course-schedule-ii/) |[Java](./Graph/CourseSchedule2.java) ||O(n<sup>3</sup>)||
|  18  |Course Schedule Iv|[LC](https://leetcode.com/problems/course-schedule-iv/) |[Java](./Graph/CourseSchedule4.java) ||O(n<sup>3</sup>)||
|  19  |Depth First Traversal For A Graph|[GFG](https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1) |[CPP](./Graph/GFG_Graph_DFSTraversal.cpp) [Java](./Graph/DFS.java) |Easy|O(n)||
|  20  |Detect Cycle In A Directed Graph|[GFG](https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1) |[CPP](./Graph/GFG_Graph_CycleDetectionDirected.cpp) [Java](./Graph/DetectCycleInDirectedGraph.java) |Medium|O(n)||
|  21  |Detect Cycle In An Undirected Graph|[GFG](https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1) |[CPP](./Graph/GFG_Graph_CycleDetectionUnDirected.cpp) [Java](./Graph/DetectCycleInUndirectedGraph.java) |Medium|O(n)||
|  22  |Distance From The Source Bellman Ford Algorithm|[GFG](https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1/) [GFG](https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1) |[CPP](./Graph/GFG_BellmanFord_NegativeCycle.cpp) [Java](./Graph/BellmanFord.java) |Medium|O(n)||
|  23  |Employee Importance|[LC](https://leetcode.com/problems/employee-importance/) |[CPP](./Graph/LC_690_EmployeeImportance.cpp) [Java](./Graph/EmployeeImportance.java) ||O(n<sup>2</sup>)||
|  24  |Euler Circuit And Path|[GFG](https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1) |[Java](./Graph/EulerCircuitAndPath.java) |Medium|O(n<sup>2</sup>)||
|  25  |Euler Circuit In A Directed Graph|[GFG](https://practice.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1) |[Java](./Graph/EulerCircuit.java) |Medium|O(n<sup>2</sup>)||
|  26  |Evaluate Division|[LC](https://leetcode.com/problems/evaluate-division/) |[Java](./Graph/EvaluateDivision.java) ||O(n)||
|  27  |Find Closest Node To Given Two Nodes|[LC](https://leetcode.com/problems/find-closest-node-to-given-two-nodes/) |[Java](./Graph/FindClosestNodeToGivenTwoNodes.java) ||O(n<sup>3</sup>)||
|  28  |Find Eventual Safe States|[LC](https://leetcode.com/problems/find-eventual-safe-states/) |[Java](./Graph/FindEventualSafeStates.java) ||O(n)||
|  29  |Find The City With The Smallest Number Of Neighbors At A Threshold Distance|[LC](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/) |[Java](./Graph/FindTheCityWithTheSmallestNumberOfNeighboursAtAThresholdDistance.java) ||O(n<sup>2</sup>)||
|  30  |Find The Number Of Islands|[GFG](https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1#) |[CPP](./Graph/GFG_Graph_Numof_Islands.cpp) |Medium|O(1)||
|  31  |Find The Town Judge|[LC](https://leetcode.com/problems/find-the-town-judge/) |[CPP](./Graph/LC_997_TownJudge.cpp) [Java](./Graph/FindTownJudge.java) ||O(n<sup>2</sup>)||
|  32  |Geekss Garden|[GFG](https://practice.geeksforgeeks.org/problems/geekss-garden/0) |[Java](./Graph/GeeksGarden.java) |Easy|O(n<sup>4</sup>)||
|  33  |Implementing Dijkstra Set 1 Adjacency Matrix|[GFG](https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1#) |[CPP](./Graph/GFG_Graph_ShortestDistance_Dijkstra.cpp) [Java](./Graph/ShortestPath.java) |Medium|O(1)||
|  34  |Implementing Floyd Warshall2042|[GFG](https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1) |[CPP](./Graph/GFG_FloydWarshall.cpp) [Java](./Graph/FloydWarshall.java) |Medium|O(n)||
|  35  |Is Graph Bipartite|[LC](https://leetcode.com/problems/is-graph-bipartite/) [GFG](https://practice.geeksforgeeks.org/problems/bipartite-graph/1) |[Java](./Graph/CheckIfBipartite.java) |Medium|O(n<sup>3</sup>)||
|  36  |Journey To The Moon|[HR](https://www.hackerrank.com/challenges/journey-to-the-moon/problem) |[Java](./Graph/JourneyToMoon.java) ||O(n)||
|  37  |Keys And Rooms|[LC](https://leetcode.com/problems/keys-and-rooms/) |[Java](./Graph/KeysAndRooms.java) ||O(n)||
|  38  |Length Of Largest Region Of 1s 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1) |[Java](./Graph/MaxAreaOfOnes.java) |Medium|O(n)||
|  39  |Longest Cycle In A Graph|[LC](https://leetcode.com/problems/longest-cycle-in-a-graph/) |[Java](./Graph/LongestCycleInAGraph.java) ||O(n)||
|  40  |Min Cost To Connect All Points|[LC](https://leetcode.com/problems/min-cost-to-connect-all-points/) |[Java](./Graph/MinCostToConnectAllThePoints.java) ||O(n)||
|  41  |Minimum Cost Path3833|[GFG](https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1) |[Java](./Graph/MinimumCostPath.java) |Hard|O(n)||
|  42  |Minimum Spanning Tree|[GFG](https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1) |[CPP](./Graph/GFG_MST.cpp) [Java](./Graph/MinimumSpanningTree.java) |Medium|O(1)||
|  43  |Minimum Swaps|[GFG](https://practice.geeksforgeeks.org/problems/minimum-swaps/1) |[Java](./Graph/MinimumSwapsToSort.java) |Medium|O(n<sup>2</sup>)||
|  44  |Network Delay Time|[LC](https://leetcode.com/problems/network-delay-time/) |[Java](./Graph/NetworkDelayTime.java) ||O(n<sup>2</sup>)||
|  45  |Number Of Closed Islands|[LC](https://leetcode.com/problems/number-of-closed-islands/) [GFG](https://practice.geeksforgeeks.org/problems/find-number-of-closed-islands/1/) |[Java](./Graph/NumberOfClosedIslands.java) |Hard|O(n)||
|  46  |Number Of Operations To Make Network Connected|[LC](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) |[Java](./Graph/ConnectNetwork.java) ||O(n)||
|  47  |Number Of Provinces|[LC](https://leetcode.com/problems/number-of-provinces/) [GFG](https://practice.geeksforgeeks.org/problems/number-of-provinces/1) |[Java](./Graph/NumberOfProvinces.java) |Medium|O(n<sup>3</sup>)||
|  48  |Parallel Courses Iii|[LC](https://leetcode.com/problems/parallel-courses-iii/) |[Java](./Graph/ParallelCourses3.java) ||O(n)||
|  49  |Possible Bipartition|[LC](https://leetcode.com/problems/possible-bipartition/) |[Java](./Graph/PossibleBipartition.java) ||O(n<sup>3</sup>)||
|  50  |Possible Paths Between 2 Vertices 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/possible-paths-between-2-vertices-1587115620/1) |[Java](./Graph/PossiblePathsBetweenTwoVertices.java) |Medium|O(n)||
|  51  |Prerequisite Tasks|[GFG](https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/) |[Java](./Graph/PrerequisiteTasks.java) |Medium|O(n<sup>2</sup>)||
|  52  |Print Adjacency List 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1#) |[CPP](./Graph/GFG_Graph_AdjListPrint.cpp) [Java](./Graph/PrintAdjList.java) |Easy|O(1)||
|  53  |Redundant Connection|[LC](https://leetcode.com/problems/redundant-connection/) |[Java](./Graph/RedundantConnection.java) ||O(n)||
|  54  |Rotting Oranges|[LC](https://leetcode.com/problems/rotting-oranges/) |[CPP](./Graph/LC_994_RottigOranges.cpp) [Java](./Graph/RottenOranges.java) ||O(1)||
|  55  |Shortest Path In Binary Matrix|[LC](https://leetcode.com/problems/shortest-path-in-binary-matrix/) |[Java](./Graph/ShortestPathInBinaryMatrix.java) ||O(n)||
|  56  |Shortest Source To Destination Path3544|[GFG](https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1/) |[Java](./Graph/ShortestSourceToDestinationPath.java) |Medium|O(n<sup>2</sup>)||
|  57  |Steps By Knight5927|[GFG](https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1/) |[Java](./Graph/MinimumStepsByKnight.java) |Medium|O(n)||
|  58  |Strongly Connected Component Tarjanss Algo 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/strongly-connected-component-tarjanss-algo-1587115621/1/) |[Java](./Graph/Tarjan.java) |Hard|O(n)||
|  59  |Strongly Connected Components Kosarajus Algo|[GFG](https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1#) |[CPP](./Graph/GFG_Graph_StronglyConnectedComp(Kosaraju).cpp) [Java](./Graph/Kosaraju.java) |Medium|O(1)||
|  60  |Surrounded Regions|[LC](https://leetcode.com/problems/surrounded-regions/) |[Java](./Graph/SurroundedRegions.java) ||O(n)||
|  61  |Time Needed To Inform All Employees|[LC](https://leetcode.com/problems/time-needed-to-inform-all-employees/) |[Java](./Graph/TimeNeededToInformAllEmployees.java) ||O(n<sup>2</sup>)||
|  62  |Topological Sort|[GFG](https://practice.geeksforgeeks.org/problems/topological-sort/1#) |[CPP](./Graph/GFG_Graph_TopologicalSort.cpp) [Java](./Graph/TopologicalSort.java) |Medium|O(1)||
|  63  |Water And Jug Problem|[LC](https://leetcode.com/problems/water-and-jug-problem/) |[Java](./Graph/WaterAndJugProblem.java) ||O(n<sup>3</sup>)||
|  64  |Where Will The Ball Fall|[LC](https://leetcode.com/problems/where-will-the-ball-fall/) |[Java](./Graph/WhereWillTheBallFall.java) ||O(n<sup>2</sup>)||
|  65  |Word Boggle4143|[GFG](https://practice.geeksforgeeks.org/problems/word-boggle4143/1/) |[Java](./Graph/WordBoggle.java) |Medium|O(n)||
|  66  |Word Ladder|[LC](https://leetcode.com/problems/word-ladder/) |[Java](./Graph/WordLadder.java) ||O(n<sup>4</sup>)||
|  67  |X Total Shapes3617|[GFG](https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1/) |[Java](./Graph/XTotalShapes.java) |Medium|O(n<sup>3</sup>)||
## Greedy

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |919|[LC2](https://www.lintcode.com/problem/919) |[Java](./Greedy/MeetingRooms2.java) ||O(n<sup>2</sup>)||
|  2  |Chocolate Distribution Problem3825|[GFG](https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1) |[Java](./Greedy/ChocolateDistribution.java) |Easy|O(n)||
|  3  |Coin Piles5152|[GFG](https://practice.geeksforgeeks.org/problems/coin-piles5152/1/) |[Java](./Greedy/CoinPiles.java) |Medium|O(n<sup>2</sup>)||
|  4  |Fractional Knapsack 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1) |[CPP](./Greedy/GFG_FractionalKnapsack.cpp) [Java](./Greedy/FractionalKnapsack.java) |Medium|O(n)||
|  5  |Hand Of Straights|[LC](https://leetcode.com/problems/hand-of-straights/) |[Java](./Greedy/HandOfStraights.java) ||O(n<sup>2</sup>)||
|  6  |Huffman Encoding3345|[GFG](https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1) |[CPP](./Greedy/GFG_HuffmanEncoding.cpp) [Java](./Greedy/HuffmanCoding.java) |Medium|O(1)||
|  7  |Job Sequencing Problem 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1) |[CPP](./Greedy/GFG_JobSequencing.cpp) [Java](./Greedy/JobScheduling.java) |Medium|O(1)||
|  8  |Largest Number With Given Sum 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/largest-number-with-given-sum-1587115620/1) |[Java](./Greedy/LargestNumberPossible.java) |Easy|O(n)||
|  9  |Make Array Zero By Subtracting Equal Amounts|[LC](https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/) |[Java](./Greedy/MakeArrayZeroBySubtractingEqualAmounts.java) ||O(n)||
|  10  |Max Length Chain|[GFG](https://practice.geeksforgeeks.org/problems/max-length-chain/1) |[CPP](./Greedy/GFG_MaxLengthChain.cpp) [Java](./Greedy/MaxLengthChain.java) |Medium|O(1)||
|  11  |Maximize Sum After K Negations1149|[GFG](https://practice.geeksforgeeks.org/problems/maximize-sum-after-k-negations1149/1) |[Java](./Greedy/MaximumSumAfterKOps.java) |Easy|O(n)||
|  12  |Maximize Toys0331|[GFG](https://practice.geeksforgeeks.org/problems/maximize-toys0331/1) |[CPP](./Greedy/GFG_MaximizeToys.cpp) [Java](./Greedy/MaximizeToys.java) |Easy|O(1)||
|  13  |Maximum Area Of A Piece Of Cake After Horizontal And Vertical Cuts|[LC](https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/) |[Java](./Greedy/MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts.java) ||O(n)||
|  14  |Maximum Number Of Groups Entering A Competition|[LC](https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/) |[Java](./Greedy/MaximumNumberOfGruopsEnteringACompetition.java) ||O(n)||
|  15  |Merge Intervals|[LC](https://leetcode.com/problems/merge-intervals/) |[CPP](./Greedy/LC_56_MergeIntervals.cpp) ||O(1)||
|  16  |Minimum Cost Of Ropes 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1) |[Java](./Greedy/MinimumCostRope.java) |Easy|O(n)||
|  17  |Minimum Deletions To Make Array Divisible|[LC](https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/) |[Java](./Greedy/MinimumDeletionsToMakeArrayDivisible.java) ||O(n<sup>2</sup>)||
|  18  |Minimum Time To Make Rope Colorful|[LC](https://leetcode.com/problems/minimum-time-to-make-rope-colorful/) |[Java](./Greedy/MinimumTimeToMakeRopeColorful.java) ||O(n<sup>2</sup>)||
|  19  |Most Profit Assigning Work|[LC](https://leetcode.com/problems/most-profit-assigning-work/) |[Java](./Greedy/MostProfitAssigningWork.java) ||O(n<sup>2</sup>)||
|  20  |N Meetings In One Room 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1/) |[CPP](./Greedy/GFG_ActivitySelection_NMeetingsInOneRoom.cpp) [Java](./Greedy/ActivitySelectionProblem.java) |Easy|O(n)||
|  21  |Pairs With Specific Difference1533|[GFG](https://practice.geeksforgeeks.org/problems/pairs-with-specific-difference1533/1) |[Java](./Greedy/SumOfPairsWithSpecificDifference.java) |Easy|O(n)||
|  22  |Queue Reconstruction By Height|[LC](https://leetcode.com/problems/queue-reconstruction-by-height/) |[Java](./Greedy/QueueReconstructionByHeight.java) ||O(n<sup>2</sup>)||
|  23  |Reducing Dishes|[LC](https://leetcode.com/problems/reducing-dishes/) |[Java](./Greedy/ReducingDishes.java) ||O(n)||
|  24  |Remove Digit From Number To Maximize Result|[LC](https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/) |[Java](./Greedy/RemoveDigitFromNumberToMaximizeResult.java) ||O(n)||
|  25  |Shop In Candy Store1145|[GFG](https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1) |[Java](./Greedy/BuyCandies.java) |Easy|O(n)||
|  26  |Shortest Impossible Sequence Of Rolls|[LC](https://leetcode.com/problems/shortest-impossible-sequence-of-rolls/) |[Java](./Greedy/ShortestImpossibleRollSequence.java) ||O(n)||
|  27  |Split The Binary String Into Substrings With Equal Number Of 0s And 1s|[GFG](https://practice.geeksforgeeks.org/problems/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/1/) |[Java](./Greedy/SplitTheBinaryStringIntoSubstringsWithEqualNumberOf0sAnd1s.java) |Medium|O(n)||
|  28  |Task Scheduler|[LC](https://leetcode.com/problems/task-scheduler/) |[Java](./Greedy/TaskScheduler.java) ||O(n)||
|  29  |Water Connection Problem5822|[GFG](https://practice.geeksforgeeks.org/problems/water-connection-problem5822/1) |[Java](./Greedy/WaterConnection.java) |Medium|O(n)||
## Hashing

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Palindromic Anagram|[BS](https://binarysearch.com/problems/Palindromic-Anagram) |[Java](./Hashing/PalindromicAnagram.java) ||O(n)||
|  2  |Smallest Intersecting Element|[BS](https://binarysearch.com/problems/Smallest-Intersecting-Element) |[Java](./Hashing/SmallestIntersectingElement.java) ||O(n<sup>2</sup>)||
|  3  |Underground Tunnel|[BS](https://binarysearch.com/problems/Underground-Tunnel) |[CPP](./Hashing/BS_UndergroundTunnel.cpp) ||O(1)||
|  4  |All Oone Data Structure|[LC](https://leetcode.com/problems/all-oone-data-structure/) |[Java](./Hashing/AllOneDataStructure.java) ||O(1)||
|  5  |Array Pair Sum Divisibility Problem3257|[GFG](https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1/) |[Java](./Hashing/ArrayPairSumDivisibilityProblem.java) |Easy|O(n)||
|  6  |Array Subset Of Another Array2317|[GFG](https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1/) |[Java](./Hashing/ArraySubsetOfAnotherArray.java) |Easy|O(n)||
|  7  |Bulls And Cows|[LC](https://leetcode.com/problems/bulls-and-cows/) |[Java](./Hashing/BullsAndCows.java) ||O(n)||
|  8  |Check If A String Contains All Binary Codes Of Size K|[LC](https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/) |[Java](./Hashing/CheckAllBinaryCodesPresence.java) ||O(n)||
|  9  |Continuous Subarray Sum|[LC](https://leetcode.com/problems/continuous-subarray-sum/) |[Java](./Hashing/ContinuousSubarraySum.java) ||O(n<sup>2</sup>)||
|  10  |Count Element Occurences|[GFG](https://practice.geeksforgeeks.org/problems/count-element-occurences/1/) |[Java](./Hashing/CountMoreThanNByKOccurences.java) |Medium|O(n)||
|  11  |Count Good Meals|[LC](https://leetcode.com/problems/count-good-meals/) |[Java](./Hashing/CountGoodMeals.java) ||O(n<sup>2</sup>)||
|  12  |Count Pairs In Array Divisible By K|[GFG](https://practice.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1) |[Java](./Hashing/CountPairsInArrayDivisibleByK.java) |Medium|O(n)||
|  13  |Count Triplets 1|[HR](https://www.hackerrank.com/challenges/count-triplets-1/) |[Java](./Hashing/CountTriplets.java) ||O(n)||
|  14  |Ctci Ransom Note|[HR](https://www.hackerrank.com/challenges/ctci-ransom-note/) |[Java](./Hashing/RansomNote.java) ||O(n)||
|  15  |Degree Of An Array|[LC](https://leetcode.com/problems/degree-of-an-array/) |[Java](./Hashing/DegreeOfAnArray.java) ||O(n)||
|  16  |Design Hashmap|[LC](https://leetcode.com/problems/design-hashmap/) |[CPP](./Hashing/LC_706_DesignHashMap.cpp) [Java](./Hashing/HashMapDesign.java) ||O(n)||
|  17  |Design Hashset|[LC](https://leetcode.com/problems/design-hashset/) |[CPP](./Hashing/LC_705_DesignHashSet.cpp) [Java](./Hashing/HashSetDesign.java) ||O(n)||
|  18  |Determine If String Halves Are Alike|[LC](https://leetcode.com/problems/determine-if-string-halves-are-alike/) |[Java](./Hashing/DetermineIfStringHalvesAreAlike.java) ||O(n)||
|  19  |Find All Duplicates In An Array|[LC](https://leetcode.com/problems/find-all-duplicates-in-an-array/) |[Java](./Hashing/FindDuplicates.java) ||O(n)||
|  20  |Find All Numbers Disappeared In An Array|[LC](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/) |[Java](./Hashing/FindDisappearedNumbers.java) ||O(n)||
|  21  |Find Common Characters|[LC](https://leetcode.com/problems/find-common-characters/) |[Java](./Hashing/FindCommonCharacters.java) ||O(n<sup>2</sup>)||
|  22  |Find Unique Binary String|[LC](https://leetcode.com/problems/find-unique-binary-string/) |[Java](./Hashing/FindMissingBinaryString.java) ||O(n<sup>2</sup>)||
|  23  |First Missing Positive|[LC](https://leetcode.com/problems/first-missing-positive/) |[Java](./Hashing/FirstMissingPositive.java) ||O(n)||
|  24  |First Non Repeating Character In A Stream1216|[GFG](https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1) |[Java](./Hashing/FindFirstNonRepeatingCharacter.java) |Medium|O(n<sup>2</sup>)||
|  25  |Group Anagrams|[LC](https://leetcode.com/problems/group-anagrams/) |[Java](./Hashing/GroupAnagrams.java) ||O(n<sup>3</sup>)||
|  26  |In First But Second5423|[GFG](https://practice.geeksforgeeks.org/problems/in-first-but-second5423/1) |[Java](./Hashing/FindMissingInSecondArray.java) |Medium|O(n)||
|  27  |Longest Palindrome By Concatenating Two Letter Words|[LC](https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/) |[Java](./Hashing/LongestPalindromeByConcatenatingTwoLetterWords.java) ||O(n)||
|  28  |Longest Subarray With Sum Divisible By K1259|[GFG](https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1) |[Java](./Hashing/LongestSubarrayWithSumDivisibleByK.java) |Medium|O(n<sup>2</sup>)||
|  29  |Longest Substring Without Repeating Characters|[LC](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |[CPP](./Hashing/GFG_LC3_LongestUniqueSubstring.cpp) [Java](./Hashing/LongestUniqueSubstring.java) ||O(1)||
|  30  |Max Distance Between Same Elements|[GFG](https://practice.geeksforgeeks.org/problems/max-distance-between-same-elements/1#) |[CPP](./Hashing/GFG_MaxDistanceBwTwoElements.cpp) |Easy|O(1)||
|  31  |Max Sum Of A Pair With Equal Sum Of Digits|[LC](https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/) |[Java](./Hashing/MaxSumOfPairWithEqualSumOfDigits.java) ||O(n<sup>2</sup>)||
|  32  |Maximum Number Of Pairs In Array|[LC](https://leetcode.com/problems/maximum-number-of-pairs-in-array/) |[Java](./Hashing/MaximumNumberOfPairsInAnArray.java) ||O(n)||
|  33  |Maximum Repeating Number4858|[GFG](https://practice.geeksforgeeks.org/problems/maximum-repeating-number4858/1) |[CPP](./Hashing/GFG_MostFreq.cpp) |Basic|O(1)||
|  34  |Minimum Consecutive Cards To Pick Up|[LC](https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/) |[Java](./Hashing/MinimumConsecutiveCardsToPickUp.java) ||O(n)||
|  35  |Most Common Word|[LC](https://leetcode.com/problems/most-common-word/) |[Java](./Hashing/MostFrequentStringIgnoringBannedOnes.java) ||O(n)||
|  36  |Most Frequent Word In An Array Of Strings3528|[GFG](https://practice.geeksforgeeks.org/problems/most-frequent-word-in-an-array-of-strings3528/1#) |[CPP](./Hashing/GFG_MostFreqWordInArrayOfStrings.cpp) [Java](./Hashing/MostFrequentString.java) |Medium|O(1)||
|  37  |Partition Labels|[LC](https://leetcode.com/problems/partition-labels/) |[Java](./Hashing/PartitionLabels.java) ||O(n)||
|  38  |Points In Straight Line|[GFG](https://practice.geeksforgeeks.org/problems/points-in-straight-line/1#) |[Java](./Hashing/PointsInStraightLine.java) |Hard|O(n<sup>2</sup>)||
|  39  |Rank Transform Of An Array|[LC](https://leetcode.com/problems/rank-transform-of-an-array/) |[Java](./Hashing/RankTransformOfAnArray.java) ||O(n<sup>2</sup>)||
|  40  |Relative Sorting4323|[GFG](https://practice.geeksforgeeks.org/problems/relative-sorting4323/1) |[Java](./Hashing/RelativeSorting.java) |Medium|O(n<sup>2</sup>)||
|  41  |Repeated Dna Sequences|[LC](https://leetcode.com/problems/repeated-dna-sequences/) |[Java](./Hashing/RepeatedDNASequences.java) ||O(n)||
|  42  |Swapping Pairs Make Sum Equal4142|[GFG](https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal4142/1/) |[Java](./Hashing/SwappingPairsMakeSumEqual.java) |Easy|O(n)||
|  43  |Top K Frequent Elements In Array|[GFG](https://practice.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1) |[Java](./Hashing/TopK.java) |Easy|O(n)||
|  44  |Top K Frequent Words|[LC](https://leetcode.com/problems/top-k-frequent-words/) |[Java](./Hashing/TopKFrequentWords.java) ||O(n)||
|  45  |Uncommon Words From Two Sentences|[LC](https://leetcode.com/problems/uncommon-words-from-two-sentences/) |[CPP](./Hashing/LC_884_UncommonWordsFromTwoSentences.cpp) [Java](./Hashing/UncommonWords.java) ||O(1)||
|  46  |Unique Email Addresses|[LC](https://leetcode.com/problems/unique-email-addresses/) |[Java](./Hashing/UniqueEmailAddresses.java) ||O(n<sup>2</sup>)||
|  47  |Unique Number Of Occurrences|[LC](https://leetcode.com/problems/unique-number-of-occurrences/) |[CPP](./Hashing/LC_1207_HT_UniqueNumOfOccurrences.cpp) ||O(1)||
## Heap

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |K Unique String|[BS](https://binarysearch.com/problems/K-Unique-String) |[Java](./Heap/KUniqueString.java) ||O(n)||
|  2  |Optimal Decrement|[BS](https://binarysearch.com/problems/Optimal-Decrement) |[Java](./Heap/OptimalDecrement.java) ||O(n)||
|  3  |Chinky And Diamonds3340|[GFG](https://practice.geeksforgeeks.org/problems/chinky-and-diamonds3340/1) |[Java](./Heap/MaximumDiamonds.java) |Easy|O(n)||
|  4  |Course Schedule Iii|[LC](https://leetcode.com/problems/course-schedule-iii/) |[Java](./Heap/CourseSchedule3.java) ||O(n)||
|  5  |Find K Pairs With Smallest Sums|[LC](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/) |[Java](./Heap/FindKPairsWithSmallestSum.java) ||O(n)||
|  6  |Find K Th Smallest Element In Given N Ranges|[GFG](https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-given-n-ranges/1/) |[Java](./Heap/FindKthSmallestElementInGivenNRanges.java) |Medium|O(n<sup>2</sup>)||
|  7  |Find Median From Data Stream|[LC](https://leetcode.com/problems/find-median-from-data-stream/) [GFG](https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1#.) |[CPP](./Heap/LC_295_FindMediaDataStream.cpp) [Java](./Heap/MedianOfAStream.java) |Hard|O(1)||
|  8  |Find Nearest Point That Has The Same X Or Y Coordinate|[LC](https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/) |[CPP](./Heap/LC_1779_FindNearestPointThatHaxSameCoordinate.cpp) [Java](./Heap/NearestPoint.java) ||O(1)||
|  9  |Find Smallest Range Containing Elements From K Lists|[GFG](https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1) |[Java](./Heap/SmallestRangeFromKArrays.java) |Hard|O(n)||
|  10  |Find Subsequence Of Length K With The Largest Sum|[LC](https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/) |[Java](./Heap/FindSubsequenceOfLengthKWithLargestSum.java) ||O(n)||
|  11  |Is Binary Tree Heap|[GFG](https://practice.geeksforgeeks.org/problems/is-binary-tree-heap/1/) |[Java](./Heap/IsHeap.java) |Easy|O(1)||
|  12  |K Closest Points To Origin|[LC](https://leetcode.com/problems/k-closest-points-to-origin/) |[CPP](./Heap/LC_973_KClosestPointsToOrigin.cpp) [Java](./Heap/KClosestPointsToOrigin.java) ||O(n)||
|  13  |K Largest Elements4206|[GFG](https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1/) |[Java](./Heap/KLargestElements.java) |Medium|O(n)||
|  14  |K Th Largest Sum Contiguous Subarray|[GFG](https://practice.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1/) |[Java](./Heap/KthLargestSumContiguousSubArray.java) |Medium|O(n<sup>2</sup>)||
|  15  |Kth Largest Element In A Stream|[LC](https://leetcode.com/problems/kth-largest-element-in-a-stream/) |[Java](./Heap/KthLargestFromStream.java) ||O(n)||
|  16  |Kth Largest Element In A Stream703.|[LC](https://leetcode.com/problems/kth-largest-element-in-a-stream703.) |[CPP](./Heap/LC_703_KthLargestEleInStream.cpp) ||O(1)||
|  17  |Kth Largest Element In An Array|[LC](https://leetcode.com/problems/kth-largest-element-in-an-array/) |[CPP](./Heap/LC_215_KthLargestEleInArray.cpp) [Java](./Heap/KthLargest.java) ||O(n)||
|  18  |Kth Smallest Element5635|[GFG](https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1/) |[CPP](./Heap/GFG_KthSmallest.cpp) |Medium|O(1)||
|  19  |Merge K Sorted Arrays|[GFG](https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1#) |[CPP](./Heap/GFG_MergeKSortedArrays.cpp) [Java](./Heap/MergeKSortedArrays.java) |Medium|O(1)||
|  20  |Merge K Sorted Lists|[LC](https://leetcode.com/problems/merge-k-sorted-lists/) |[CPP](./Heap/LC_23_MergerKSortedLists.cpp) [Java](./Heap/MergeKSortedLists.java) ||O(1)||
|  21  |Merge Two Binary Max Heap0144|[GFG](https://practice.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1/) |[Java](./Heap/MergeTwoBinaryMaxHeaps.java) |Easy|O(n<sup>2</sup>)||
|  22  |Minimum Cost Of Ropes 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1) |[Java](./Heap/MinCostOfRopes.java) |Easy|O(n)||
|  23  |Minimum Sum4058|[GFG](https://practice.geeksforgeeks.org/problems/minimum-sum4058/1/) |[Java](./Heap/MinimumSum.java) |Medium|O(n)||
|  24  |Single Threaded Cpu|[LC](https://leetcode.com/problems/single-threaded-cpu/) |[Java](./Heap/SingleThreadedCPU.java) ||O(n)||
|  25  |Sliding Window Median|[LC](https://leetcode.com/problems/sliding-window-median/) |[Java](./Heap/SlidingWindowMedian.java) ||O(n)||
|  26  |The K Weakest Rows In A Matrix|[LC](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/) |[Java](./Heap/KWeakestRowsInMatrix.java) ||O(n)||
|  27  |Top K Frequent Words|[LC](https://leetcode.com/problems/top-k-frequent-words/) |[CPP](./Heap/LC_692_TopKFrequentWords.cpp) ||O(1)||
## Linked-List

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |87f12e5c728d69a5322634776b54c75897d14daa|[GFG](https://practice.geeksforgeeks.org/problems/87f12e5c728d69a5322634776b54c75897d14daa/1/) |[Java](./Linked-List/CountTriplets.java) |Medium|O(n<sup>2</sup>)||
|  2  |Central Linked List|[BS](https://binarysearch.com/problems/Central-Linked-List) [LC](https://leetcode.com/problems/middle-of-the-linked-list/) [GFG](https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1/) |[CPP](./Linked-List/LC_876_MiddleOfTheLinkedList.cpp) |Easy|O(n<sup>2</sup>)||
|  3  |Interleaved Linked List|[BS](https://binarysearch.com/problems/Interleaved-Linked-List) |[Java](./Linked-List/InterleavedLinkedList.java) ||O(n)||
|  4  |Linked List Union|[BS](https://binarysearch.com/problems/Linked-List-Union) |[Java](./Linked-List/LinkedListUnion.java) ||O(n)||
|  5  |Pairwise Linked List Swap|[BS](https://binarysearch.com/problems/Pairwise-Linked-List-Swap) [LC](https://leetcode.com/problems/swap-nodes-in-pairs/) |[Java](./Linked-List/SwapNodesInPairs.java) ||O(n)||
|  6  |Reverse A Linked List|[BS](https://binarysearch.com/problems/Reverse-a-Linked-List) [LC](https://leetcode.com/problems/reverse-linked-list/) |[CPP](./Linked-List/LC_206_LinkedL_ReverseLinkedList.cpp) [Java](./Linked-List/ReverseList.java) ||O(1)||
|  7  |Swap Kth Node Values|[BS](https://binarysearch.com/problems/Swap-Kth-Node-Values) |[Java](./Linked-List/SwapKthNodeValues.java) ||O(n)||
|  8  |Add 1 To A Number Represented As Linked List|[GFG](https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1/) |[Java](./Linked-List/AddOne.java) |Easy|O(1)||
|  9  |Add Two Numbers|[LC](https://leetcode.com/problems/add-two-numbers/) |[Java](./Linked-List/AddLists.java) ||O(n)||
|  10  |Add Two Numbers Ii|[LC](https://leetcode.com/problems/add-two-numbers-ii/) [GFG](https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1) |[Java](./Linked-List/AddLists2.java) |Easy|O(n)||
|  11  |Check If Linked List Is Pallindrome|[GFG](https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1) |[Java](./Linked-List/CheckPalindrome.java) |Easy|O(n)||
|  12  |Circular Linked List|[GFG](https://practice.geeksforgeeks.org/problems/circular-linked-list/1) |[CPP](./Linked-List/GFG_LinkedL_CheckCircularLinkedList.cpp) [Java](./Linked-List/CheckIfCircularLinkedList.java) |Basic|O(n)||
|  13  |Convert Binary Number In A Linked List To Integer|[LC](https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/) |[Java](./Linked-List/ConvertToDecimal.java) ||O(1)||
|  14  |Copy List With Random Pointer|[LC](https://leetcode.com/problems/copy-list-with-random-pointer/) [GFG](https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1) |[Java](./Linked-List/CloneList.java) |Hard|O(n)||
|  15  |Decimal Equivalent Of Binary Linked List|[GFG](https://practice.geeksforgeeks.org/problems/decimal-equivalent-of-binary-linked-list/1) |[CPP](./Linked-List/GFG_DecimalOfBinaryLL.cpp) [Java](./Linked-List/DecimalEquivalentOfBinaryLinkedList.java) |Easy|O(n)||
|  16  |Delete Middle Of Linked List|[GFG](https://practice.geeksforgeeks.org/problems/delete-middle-of-linked-list/1) |[CPP](./Linked-List/GFG_DeleteMiddleLinkedList.cpp) [Java](./Linked-List/DeleteMiddleNode.java) |Easy|O(n)||
|  17  |Delete N Nodes After M Nodes Of A Linked List|[GFG](https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1) |[CPP](./Linked-List/GFG_DeleteNnodesAfterMnodes.cpp) [Java](./Linked-List/LinkDelete.java) |Easy|O(1)||
|  18  |Delete Nodes Having Greater Value On Right|[GFG](https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1) |[Java](./Linked-List/FindLeaders.java) |Medium|O(1)||
|  19  |Deletion And Reverse In Linked List|[GFG](https://practice.geeksforgeeks.org/problems/deletion-and-reverse-in-linked-list/1) |[Java](./Linked-List/DeleteAndReverseCircular.java) |Easy|O(n)||
|  20  |Flatten A Multilevel Doubly Linked List|[LC](https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/) [GFG](https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1) |[Java](./Linked-List/FlattenLinkedList.java) |Medium|O(n)||
|  21  |Given A Linked List Of 0s 1s And 2s Sort It|[GFG](https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1) |[Java](./Linked-List/ZeroOneTwo.java) |Easy|O(n)||
|  22  |Given A Linked List Reverse Alternate Nodes And Append At The End|[GFG](https://practice.geeksforgeeks.org/problems/given-a-linked-list-reverse-alternate-nodes-and-append-at-the-end/) |[Java](./Linked-List/ReverseAlternateNodes.java) |null|O(n)||
|  23  |Implement Stack Using Queues|[LC](https://leetcode.com/problems/implement-stack-using-queues/) |[CPP](./Linked-List/LC_225_StackUsingQueue.cpp) ||O(1)||
|  24  |Intersection Of Two Linked List|[GFG](https://practice.geeksforgeeks.org/problems/intersection-of-two-linked-list/1) |[Java](./Linked-List/IntersectionOfLists.java) |Easy|O(n)||
|  25  |Intersection Of Two Sorted Linked Lists|[GFG](https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1) |[Java](./Linked-List/IntersectionOfSortedLists.java) |Easy|O(n)||
|  26  |Length Of Longest Palindrome In Linked List|[GFG](https://practice.geeksforgeeks.org/problems/length-of-longest-palindrome-in-linked-list/1/) |[Java](./Linked-List/LongestPalindromeInLinkedList.java) |Medium|O(n)||
|  27  |Linked List Cycle|[LC](https://leetcode.com/problems/linked-list-cycle/) |[CPP](./Linked-List/LC_141_DetectCycle.cpp) [Java](./Linked-List/DetectCycle.java) ||O(n)||
|  28  |Linked List Cycle Ii|[LC](https://leetcode.com/problems/linked-list-cycle-ii/) |[CPP](./Linked-List/LC_142_LLCyle2.cpp) [Java](./Linked-List/LocateCycle.java) ||O(1)||
|  29  |Linked List Of Strings Forms A Palindrome|[GFG](https://practice.geeksforgeeks.org/problems/linked-list-of-strings-forms-a-palindrome/1) |[Java](./Linked-List/CombinedStringPalindrome.java) |Easy|O(n)||
|  30  |Linked List That Is Sorted Alternatingly|[GFG](https://practice.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1) |[Java](./Linked-List/LinkedListThatIsSortedAlternatingly.java) |Easy|O(n)||
|  31  |Merge 2 Sorted Linked List In Reverse Order|[GFG](https://practice.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1) |[Java](./Linked-List/ReverseMerging.java) |Easy|O(n)||
|  32  |Merge Sort On Doubly Linked List|[GFG](https://practice.geeksforgeeks.org/problems/merge-sort-on-doubly-linked-list/1) |[Java](./Linked-List/MergeSortDoubly.java) |Medium|O(n)||
|  33  |Merge Two Sorted Lists|[LC](https://leetcode.com/problems/merge-two-sorted-lists/submissions/) |[Java](./Linked-List/MergeTwoSortedLists.java) ||O(n)||
|  34  |Middle Of The Linked List|[LC](https://leetcode.com/problems/middle-of-the-linked-list/) |[Java](./Linked-List/FindMiddleNode.java) ||O(n)||
|  35  |Modify Linked List 1|[GFG](https://practice.geeksforgeeks.org/problems/modify-linked-list-1/1) |[Java](./Linked-List/ModifyLinkedList-1.java) |Easy|O(n)||
|  36  |Multiply Two Linked Lists|[GFG](https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1) |[Java](./Linked-List/MultiplyLists.java) |Easy|O(n)||
|  37  |Next Greater Node In Linked List|[LC](https://leetcode.com/problems/next-greater-node-in-linked-list/) |[Java](./Linked-List/NextGreaterNodeInLinkedList.java) ||O(n)||
|  38  |Odd Even Linked List|[LC](https://leetcode.com/problems/odd-even-linked-list/) |[CPP](./Linked-List/LC_328_OddEvenLL.cpp) [Java](./Linked-List/OddEven.java) ||O(1)||
|  39  |Partition A Linked List Around A Given Value|[GFG](https://practice.geeksforgeeks.org/problems/partition-a-linked-list-around-a-given-value/1/#) |[CPP](./Linked-List/GFG_PartitionLL.cpp) [Java](./Linked-List/Partition.java) |Medium|O(1)||
|  40  |Partition List|[LC](https://leetcode.com/problems/partition-list/) |[Java](./Linked-List/PartitionList.java) ||O(n)||
|  41  |Polynomial Addition|[GFG](https://practice.geeksforgeeks.org/problems/polynomial-addition/1) |[Java](./Linked-List/PolynomialAddition.java) |Medium|O(n)||
|  42  |Quick Sort On Linked List|[GFG](https://practice.geeksforgeeks.org/problems/quick-sort-on-linked-list/1) |[Java](./Linked-List/QuickSort.java) |Medium|O(n)||
|  43  |Remove All Occurences Of Duplicates In A Linked List|[GFG](https://practice.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1) |[Java](./Linked-List/RemoveAllOccurrencesOfDuplicatesInALinkedList.java) |Medium|O(n)||
|  44  |Remove Duplicates From Sorted List|[LC](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) |[Java](./Linked-List/RemoveDuplicates.java) ||O(n)||
|  45  |Remove Duplicates From Sorted List Ii|[LC](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) |[Java](./Linked-List/RemoveDuplicates2.java) ||O(n)||
|  46  |Remove Every Kth Node|[GFG](https://practice.geeksforgeeks.org/problems/remove-every-kth-node/1) |[Java](./Linked-List/RemoveEveryKthNode.java) |Easy|O(n)||
|  47  |Remove Linked List Elements|[LC](https://leetcode.com/problems/remove-linked-list-elements/) |[CPP](./Linked-List/LC_203_LinkedL_RemoveLinedListElements.cpp) [Java](./Linked-List/RemoveLinkedListElements.java) ||O(1)||
|  48  |Remove Loop In Linked List|[GFG](https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1) |[CPP](./Linked-List/GFG_RemoveLoopLL.cpp) [Java](./Linked-List/RemoveCycle.java) |Medium|O(1)||
|  49  |Remove Nth Node From End Of List|[LC](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) [GFG](https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1/#) |[CPP](./Linked-List/LC_19_RemoveNthNodeFromEndOfList.cpp) [Java](./Linked-List/NthNodeFromEnd.java) |Easy|O(1)||
|  50  |Reorder List|[LC](https://leetcode.com/problems/reorder-list/) |[Java](./Linked-List/ReorderList.java) ||O(n)||
|  51  |Reverse A Doubly Linked List|[GFG](https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1) |[Java](./Linked-List/ReverseDoublyLinkedList.java) |Easy|O(n<sup>2</sup>)||
|  52  |Reverse A Linked List In Groups Of Given Size|[GFG](https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1) |[CPP](./Linked-List/GFG_ReverseLLinGroupsOfGivenSize.cpp) |Medium|O(1)||
|  53  |Reverse Linked List Ii|[LC](https://leetcode.com/problems/reverse-linked-list-ii/) |[Java](./Linked-List/ReverseLinkedList2.java) ||O(n)||
|  54  |Reverse Nodes In K Group|[LC](https://leetcode.com/problems/reverse-nodes-in-k-group/) |[CPP](./Linked-List/LC_25_ReverseNodesInKGroup.cpp) [Java](./Linked-List/ReverseInGroups.java) ||O(1)||
|  55  |Rotate A Linked List|[GFG](https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1) |[CPP](./Linked-List/GFG_RotateLinkedList.cpp) [Java](./Linked-List/RotateList.java) |Medium|O(1)||
|  56  |Rotate List|[LC](https://leetcode.com/problems/rotate-list/) |[CPP](./Linked-List/LC_61_RotateList.cpp) ||O(1)||
|  57  |Segregate Even And Odd Nodes In A Linked List5035|[GFG](https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1) |[CPP](./Linked-List/GFG_SegregateEvenOddNodes.cpp) [Java](./Linked-List/SegregateOddEvenNumbers.java) |Easy|O(1)||
|  58  |Sort A Linked List|[GFG](https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1) |[Java](./Linked-List/MergeSort.java) |Medium|O(n)||
|  59  |Sorted Insert For Circular Linked List|[GFG](https://practice.geeksforgeeks.org/problems/sorted-insert-for-circular-linked-list/1) |[Java](./Linked-List/SortedInsertForCircularLinkedList.java) |Easy|O(n)||
|  60  |Split A Circular Linked List Into Two Halves|[GFG](https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1) |[Java](./Linked-List/DivideCircularList.java) |Easy|O(n)||
|  61  |Swap Nodes In Pairs|[LC](https://leetcode.com/problems/swap-nodes-in-pairs/) |[CPP](./Linked-List/LC_24_SwapNodesInPairs.cpp) ||O(1)||
## Matrix

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Bomber Man|[BS](https://binarysearch.com/problems/Bomber-Man) |[CPP](./Matrix/BS_BomberMan.cpp) [Java](./Matrix/BomberMan.java) ||O(n<sup>2</sup>)||
|  2  |Condo Developers|[BS](https://binarysearch.com/problems/Condo-Developers) |[Java](./Matrix/CondoDevelopers.java) ||O(n<sup>2</sup>)||
|  3  |Conway's Game Of Life|[BS](https://binarysearch.com/problems/Conway's-Game-of-Life) |[CPP](./Matrix/LC_289_ConwayGameOfLife.cpp) [Java](./Matrix/ConwaysGameOfLife.java) ||O(n<sup>2</sup>)||
|  4  |Enclosed Islands|[BS](https://binarysearch.com/problems/Enclosed-Islands) [LC](https://leetcode.com/problems/number-of-enclaves/) |[Java](./Matrix/NumberOfEnclaves.java) ||O(n<sup>2</sup>)||
|  5  |Matrix Search|[BS](https://binarysearch.com/problems/Matrix-Search) [GFG](https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1) |[Java](./Matrix/kthSmallestElement.java) |Medium|O(n<sup>3</sup>)||
|  6  |N Lexicographic Integers|[BS](https://binarysearch.com/problems/N-Lexicographic-Integers) |[CPP](./Matrix/BS_NLexicographicIntegers.cpp) ||O(1)||
|  7  |Spiral Matrix|[BS](https://binarysearch.com/problems/Spiral-Matrix) [LC](https://leetcode.com/problems/spiral-matrix/) [GFG](https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1) |[Java](./Matrix/SpiralTraversal.java) |Medium|O(n)||
|  8  |Zero Matrix|[BS](https://binarysearch.com/problems/Zero-Matrix) |[Java](./Matrix/ZeroMatrix.java) ||O(n<sup>2</sup>)||
|  9  |Adventure In A Maze2051|[GFG](https://practice.geeksforgeeks.org/problems/adventure-in-a-maze2051/1) |[Java](./Matrix/AdventureInAMaze.java) |null|O(n)||
|  10  |Boolean Matrix Problem 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/1) |[CPP](./Matrix/GFG_BooleanMatrix.cpp) [Java](./Matrix/BooleanMatrixFlooding.java) |Medium|O(n<sup>2</sup>)||
|  11  |Boundary Elements Of Matrix1102|[GFG](https://practice.geeksforgeeks.org/problems/boundary-elements-of-matrix1102/1) |[CPP](./Matrix/GFG_BoundaryTraversal.cpp) [Java](./Matrix/BoundaryElements.java) |Easy|O(n)||
|  12  |Check If Matrix Is X Matrix|[LC](https://leetcode.com/problems/check-if-matrix-is-x-matrix/) |[Java](./Matrix/CheckIfMatrixIsXMatrix.java) ||O(n)||
|  13  |Count Occurences Of A Given Word In A 2 D Array|[GFG](https://practice.geeksforgeeks.org/problems/count-occurences-of-a-given-word-in-a-2-d-array/1/) |[Java](./Matrix/CountOccurencesOfAGivenWordInA2DArray.java) |null|O(n)||
|  14  |Count Servers That Communicate|[LC](https://leetcode.com/problems/count-servers-that-communicate/) |[CPP](./Matrix/LC_1267_CountServersThatCommunicate.cpp) [Java](./Matrix/CountServers.java) ||O(n<sup>2</sup>)||
|  15  |Equal Row And Column Pairs|[LC](https://leetcode.com/problems/equal-row-and-column-pairs/) |[Java](./Matrix/EqualRowAndColumnPairs.java) ||O(n<sup>2</sup>)||
|  16  |Find Nth Element Of Spiral Matrix|[GFG](https://practice.geeksforgeeks.org/problems/find-nth-element-of-spiral-matrix/1#) |[CPP](./Matrix/GFG_NthEleOfSpiralMat.cpp) [Java](./Matrix/NthSpiralElement.java) |Medium|O(1)||
|  17  |Find The String In Grid0111|[GFG](https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1) |[Java](./Matrix/MedianInARowWiseSortedMatrix.java) |Medium|O(n<sup>2</sup>)||
|  18  |Flood Fill|[LC](https://leetcode.com/problems/flood-fill/) |[CPP](./Matrix/LC_733_Mat_FloodFill.cpp) ||O(1)||
|  19  |Game Of Life|[LC](https://leetcode.com/problems/game-of-life/) |[Java](./Matrix/LifeGame.java) ||O(n<sup>2</sup>)||
|  20  |Island Perimeter|[LC](https://leetcode.com/problems/island-perimeter/) |[Java](./Matrix/IslandPerimeter.java) ||O(n<sup>2</sup>)||
|  21  |Kth Smallest Element In A Sorted Matrix|[LC](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/) [GFG](https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1#) |[CPP](./Matrix/GFG_KthElementInMatrix.cpp) |Medium|O(1)||
|  22  |Largest Rectangular Sub Matrix Whose Sum Is 0|[GFG](https://practice.geeksforgeeks.org/problems/largest-rectangular-sub-matrix-whose-sum-is-0/1/) |[Java](./Matrix/LargestRectangularSubMatrixWhoseSumIsZero.java) |null|O(n<sup>3</sup>)||
|  23  |Largest Zigzag Sequence5416|[GFG](https://practice.geeksforgeeks.org/problems/largest-zigzag-sequence5416/1) |[Java](./Matrix/LargestZigzagSum.java) |Easy|O(n<sup>3</sup>)||
|  24  |Max Rectangle|[GFG](https://practice.geeksforgeeks.org/problems/max-rectangle/1/) |[Java](./Matrix/LargestRectangle.java) |Medium|O(n<sup>2</sup>)||
|  25  |Maximum Area Of Triangle|[IB](https://www.interviewbit.com/problems/maximum-area-of-triangle/) |[Java](./Matrix/MaximumAreaOfATriangle.java) ||O(n<sup>2</sup>)||
|  26  |Maximum Difference Between Pair In A Matrix|[GFG](https://practice.geeksforgeeks.org/problems/maximum-difference-between-pair-in-a-matrix/1/) |[Java](./Matrix/MaximumDifferenceBetweenPairInAMatrix.java) |Hard|O(n<sup>2</sup>)||
|  27  |Maximum Sum Rectangle2948|[GFG](https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1) |[Java](./Matrix/MaximumSumRectangle.java) |null|O(n)||
|  28  |Minesweeper|[LC](https://leetcode.com/problems/minesweeper/) |[Java](./Matrix/Minesweeper.java) ||O(n<sup>2</sup>)||
|  29  |Number Of Palindromic Paths In A Matrix0819|[GFG](https://practice.geeksforgeeks.org/problems/number-of-palindromic-paths-in-a-matrix0819/1#) |[Java](./Matrix/NumberOfPalindromicPathsInMatrix.java) |Medium|O(n)||
|  30  |Prettyprint|[IB](https://www.interviewbit.com/problems/prettyprint/) |[Java](./Matrix/PrettyPrint.java) ||O(n<sup>2</sup>)||
|  31  |Print Diagonally1623|[GFG](https://practice.geeksforgeeks.org/problems/print-diagonally1623/1) |[Java](./Matrix/AntiDiagonalTraversal.java) |Medium|O(n<sup>2</sup>)||
|  32  |Print Matrix In Diagonal Pattern|[GFG](https://practice.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1) |[Java](./Matrix/DiagonalTraversal.java) |Easy|O(n<sup>2</sup>)||
|  33  |Rank Of Matrix|[GFG](https://practice.geeksforgeeks.org/problems/rank-of-matrix/0) |[Java](./Matrix/RankOfAMatrix.java) |Medium|O(n<sup>3</sup>)||
|  34  |Reverse Spiral Form Of Matrix4033|[GFG](https://practice.geeksforgeeks.org/problems/reverse-spiral-form-of-matrix4033/1) |[Java](./Matrix/ReverseSpiralTraversal.java) |Medium|O(n<sup>2</sup>)||
|  35  |Rotate Image|[LC](https://leetcode.com/problems/rotate-image/) |[CPP](./Matrix/LC_48_RotateImage.cpp) [Java](./Matrix/RotateImage.java) ||O(1)||
|  36  |Rotate Matrix Elements Clockwise2336|[GFG](https://practice.geeksforgeeks.org/problems/rotate-matrix-elements-clockwise2336/1) |[Java](./Matrix/RotateMatrixElementsClockwise.java) |Easy|O(n<sup>2</sup>)||
|  37  |Row With Max 1s0023|[GFG](https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1#) |[CPP](./Matrix/GFG_RowWithMax1s.cpp) [Java](./Matrix/MaximumOnes.java) |Medium|O(1)||
|  38  |Row With Minimum Number Of 1s5430|[GFG](https://practice.geeksforgeeks.org/problems/row-with-minimum-number-of-1s5430/1) |[Java](./Matrix/RowWithMinimumOnes.java) |Easy|O(n<sup>2</sup>)||
|  39  |Search A 2d Matrix|[LC](https://leetcode.com/problems/search-a-2d-matrix/) |[CPP](./Matrix/LC_74_Search2DMatrix.cpp) [Java](./Matrix/SearchMatrix.java) ||O(1)||
|  40  |Search A 2d Matrix Ii|[LC](https://leetcode.com/problems/search-a-2d-matrix-ii/) [GFG](https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1#) |[CPP](./Matrix/LC_74_Search2DMatrix-2.cpp) [Java](./Matrix/SearchMatrix2.java) |Medium|O(1)||
|  41  |Set Matrix Zeroes|[LC](https://leetcode.com/problems/set-matrix-zeroes/) |[CPP](./Matrix/LC_73_SetMatrixZeroes.cpp) [Java](./Matrix/FillMatrixWithZero.java) ||O(n<sup>2</sup>)||
|  42  |Sort The Matrix Diagonally|[LC](https://leetcode.com/problems/sort-the-matrix-diagonally/) [GFG](https://practice.geeksforgeeks.org/problems/diagonal-morning-assembly0028/1/#) |[CPP](./Matrix/LC_1329_SortMatrixDiagonally.cpp) [Java](./Matrix/SortDiagonally.java) |Medium|O(1)||
|  43  |Spiral Matrix|[LC](https://leetcode.com/problems/spiral-matrix/) |[CPP](./Matrix/LC_54_Spiral.cpp) ||O(1)||
|  44  |Spiral Matrix Ii|[LC](https://leetcode.com/problems/spiral-matrix-ii/) |[CPP](./Matrix/LC_59_SpiralMatrixII.cpp) [Java](./Matrix/SpiralStorage.java) ||O(1)||
|  45  |Spiral Matrix Iii|[LC](https://leetcode.com/problems/spiral-matrix-iii/) |[Java](./Matrix/SpiralMatrix3.java) ||O(n<sup>2</sup>)||
|  46  |Spiral Matrix Iv|[LC](https://leetcode.com/problems/spiral-matrix-iv/) |[Java](./Matrix/SpiralMatrix4.java) ||O(n<sup>2</sup>)||
|  47  |Transpose Matrix|[LC](https://leetcode.com/problems/transpose-matrix/) |[CPP](./Matrix/LC_867_TransposeMatrix.cpp) [Java](./Matrix/Transpose.java) ||O(1)||
|  48  |Valid Sudoku|[LC](https://leetcode.com/problems/valid-sudoku/) |[CPP](./Matrix/LC_36_ValidSudoko.cpp) [Java](./Matrix/IsValidSudoku.java) ||O(n<sup>2</sup>)||
## Miscellaneous

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Compressed Vector Product|[BS](https://binarysearch.com/problems/Compressed-Vector-Product) |[Java](./Miscellaneous/CompressedVectorProduct.java) ||O(n)||
|  2  |Contiguous Intervals|[BS](https://binarysearch.com/problems/Contiguous-Intervals) |[Java](./Miscellaneous/ContiguousIntervals.java) ||O(n)||
|  3  |Contiguously Increasing Numbers|[BS](https://binarysearch.com/problems/Contiguously-Increasing-Numbers) |[Java](./Miscellaneous/ContiguouslyIncreasingNumbers.java) ||O(n)||
|  4  |Dropped Sensor Metric|[BS](https://binarysearch.com/problems/Dropped-Sensor-Metric) |[Java](./Miscellaneous/DroppedSensorMetric.java) ||O(n)||
|  5  |Quadratic Application|[BS](https://binarysearch.com/problems/Quadratic-Application) |[Java](./Miscellaneous/QuadraticApplication.java) ||O(n)||
|  6  |Roman Numeral To Integer|[BS](https://binarysearch.com/problems/Roman-Numeral-to-Integer) |[Java](./Miscellaneous/RomanToInteger.java) ||O(n)||
|  7  |The Auditor|[BS](https://binarysearch.com/problems/The-Auditor) [LC](https://leetcode.com/problems/excel-sheet-column-number/) |[Java](./Miscellaneous/ExcelSheetColumnNumber.java) ||O(n)||
|  8  |Underground Tunnel|[BS](https://binarysearch.com/problems/Underground-Tunnel) |[Java](./Miscellaneous/UndergroundTunnel.java) ||O(n)||
|  9  |Virtually Cloneable Stacks|[BS](https://binarysearch.com/problems/Virtually-Cloneable-Stacks) |[Java](./Miscellaneous/VirtuallyCloneableStacks.java) ||O(n)||
|  10  |Zipped Iterator|[BS](https://binarysearch.com/problems/Zipped-Iterator) |[CPP](./Miscellaneous/BS_ZippedIterator.cpp) [Java](./Miscellaneous/ZippedIterator.java) ||O(1)||
|  11  |Array Of Doubled Pairs|[LC](https://leetcode.com/problems/array-of-doubled-pairs/) |[Java](./Miscellaneous/ArrayOfDoubledPairs.java) ||O(n)||
|  12  |Basic Calculator|[LC](https://leetcode.com/problems/basic-calculator/) |[Java](./Miscellaneous/BasicCalculator.java) ||O(n<sup>2</sup>)||
|  13  |Basic Calculator Ii|[LC](https://leetcode.com/problems/basic-calculator-ii/) |[Java](./Miscellaneous/BasicCalculator2.java) ||O(n<sup>2</sup>)||
|  14  |Best Poker Hand|[LC](https://leetcode.com/problems/best-poker-hand/) |[Java](./Miscellaneous/BestPokerHand.java) ||O(n)||
|  15  |Best Time To Buy And Sell Stock|[LC](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) |[Java](./Miscellaneous/BestTimeToBuyAndSellStock1.java) ||O(n)||
|  16  |Best Time To Buy And Sell Stock Iii|[LC](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) [GFG](https://practice.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1/) |[Java](./Miscellaneous/BestTimeToBuyAndSellStock3.java) |Medium|O(n)||
|  17  |Binary Search|[GFG](https://practice.geeksforgeeks.org/problems/binary-search/1) |[Java](./Miscellaneous/EatBananasInKHours.java) |Basic|O(n)||
|  18  |Binary Searchable Elements|[GFG](https://practice.geeksforgeeks.org/problems/binary-searchable-elements/1) |[Java](./Miscellaneous/BinarySearchableElements.java) |Medium|O(n)||
|  19  |Check If Number Has Equal Digit Count And Digit Value|[LC](https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/) |[Java](./Miscellaneous/CheckIfNumberHasEqualDigitCountAndDigitValue.java) ||O(n)||
|  20  |Convert A Sentence Into Its Equivalent Mobile Numeric Keypad Sequence0547|[GFG](https://practice.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1) |[Java](./Miscellaneous/ConvertASentenceIntoItsEquivalentNumericKeypadSequence.java) |Easy|O(n<sup>2</sup>)||
|  21  |Cosmic Number|[GFG](https://practice.geeksforgeeks.org/problems/cosmic-number/0) |[Java](./Miscellaneous/CosmicNumber.java) |Easy|O(n<sup>2</sup>)||
|  22  |Count Asterisks|[LC](https://leetcode.com/problems/count-asterisks/) |[Java](./Miscellaneous/CountAsterisks.java) ||O(n)||
|  23  |Count Items Matching A Rule|[LC](https://leetcode.com/problems/count-items-matching-a-rule/) |[Java](./Miscellaneous/CountItemsMatchingARule.java) ||O(n)||
|  24  |Design A Food Rating System|[LC](https://leetcode.com/problems/design-a-food-rating-system/) |[Java](./Miscellaneous/DesignAFoodRatingSystem.java) ||O(n)||
|  25  |Design A Number Container System|[LC](https://leetcode.com/problems/design-a-number-container-system/) |[Java](./Miscellaneous/DesignANumberContainerSystem.java) ||O(1)||
|  26  |Design Underground System|[LC](https://leetcode.com/problems/design-underground-system/) |[Java](./Miscellaneous/UnderGroundSystemDesign.java) ||O(n)||
|  27  |Elimination Game|[LC](https://leetcode.com/problems/elimination-game/) |[Java](./Miscellaneous/EliminationGame.java) ||O(n<sup>2</sup>)||
|  28  |Excel Sheet Column Title|[LC](https://leetcode.com/problems/excel-sheet-column-title/) |[Java](./Miscellaneous/ExcelSheetColumnTitle.java) ||O(n)||
|  29  |Geek And Bridges|[GFG](https://practice.geeksforgeeks.org/problems/geek-and-bridges/0) |[Java](./Miscellaneous/GeekAndBridges.java) |Easy|O(n<sup>3</sup>)||
|  30  |Geek Onacci Number|[GFG](https://practice.geeksforgeeks.org/problems/geek-onacci-number/0) |[Java](./Miscellaneous/GeekONacciNumber.java) |Easy|O(n<sup>2</sup>)||
|  31  |Get Watched Videos By Your Friends|[LC](https://leetcode.com/problems/get-watched-videos-by-your-friends/) |[Java](./Miscellaneous/GetWatchedVideosByYourFriends.java) ||O(n<sup>3</sup>)||
|  32  |Happy Number|[LC](https://leetcode.com/problems/happy-number/) |[Java](./Miscellaneous/HappyNumber.java) ||O(n<sup>2</sup>)||
|  33  |Insert Delete Getrandom O1|[LC](https://leetcode.com/problems/insert-delete-getrandom-o1/) |[Java](./Miscellaneous/InsertDeleteRandom.java) ||O(n)||
|  34  |Integer To English Words|[LC](https://leetcode.com/problems/integer-to-english-words/) |[Java](./Miscellaneous/IntegerToEnglishWords.java) ||O(n)||
|  35  |Invalid Transactions|[LC](https://leetcode.com/problems/invalid-transactions/) |[Java](./Miscellaneous/InvalidTransactions.java) ||O(n<sup>2</sup>)||
|  36  |K Subarray Sum|[GFG](https://practice.geeksforgeeks.org/problems/k-subarray-sum/0) |[Java](./Miscellaneous/KSubArraySum.java) |Easy|O(n<sup>2</sup>)||
|  37  |Letter Combinations Of A Phone Number|[LC](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) |[Java](./Miscellaneous/LetterCombinations.java) ||O(n)||
|  38  |Longest Binary Subsequence Less Than Or Equal To K|[LC](https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/) |[Java](./Miscellaneous/LongestBinarySubsequenceLessThanOrEqualToK.java) ||O(n)||
|  39  |Longest Subarray With Atmost K Even Elements|[GFG](https://practice.geeksforgeeks.org/problems/longest-subarray-with-atmost-k-even-elements/0) |[Java](./Miscellaneous/LongestSubarrayWithAtMostKEvenElements.java) |Easy|O(n<sup>2</sup>)||
|  40  |Maximum Consecutive Floors Without Special Floors|[LC](https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/) |[Java](./Miscellaneous/MaximumConsecutiveFloorsWithoutSpeicalFloors.java) ||O(n)||
|  41  |Maximum Difference Between Increasing Elements|[LC](https://leetcode.com/problems/maximum-difference-between-increasing-elements/) |[Java](./Miscellaneous/MaximumDifferenceBetweenIncreasingElements.java) ||O(n)||
|  42  |Min Number Of Flips3210|[GFG](https://practice.geeksforgeeks.org/problems/min-number-of-flips3210/1) |[Java](./Miscellaneous/MinimumNumberOfFlips.java) |Easy|O(n)||
|  43  |Minimum Amount Of Time To Fill Cups|[LC](https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/) |[Java](./Miscellaneous/MinimumAmountOfTimeToFillCups.java) ||O(n)||
|  44  |Minimum Depth Of Binary Tree|[LC](https://leetcode.com/problems/minimum-depth-of-binary-tree/) |[Java](./Miscellaneous/MinDepth.java) ||O(1)||
|  45  |Minimum Number Of Increments On Subarrays To Form A Target Array|[LC](https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/) |[Java](./Miscellaneous/MinimumNumberOfIncrementsOnSubarraysToFormATargetArray.java) ||O(n)||
|  46  |Minimum Operations To Reduce X To Zero|[LC](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/) |[Java](./Miscellaneous/MinOpsToReduceXToZero.java) ||O(n<sup>2</sup>)||
|  47  |New Year Chaos|[HR](https://www.hackerrank.com/challenges/new-year-chaos/) |[Java](./Miscellaneous/NewYearChaos.java) ||O(n)||
|  48  |Print Pattern3549|[GFG](https://practice.geeksforgeeks.org/problems/print-pattern3549/1) |[Java](./Miscellaneous/PrintPattern.java) |Easy|O(1)||
|  49  |Query Kth Smallest Trimmed Number|[LC](https://leetcode.com/problems/query-kth-smallest-trimmed-number/) |[Java](./Miscellaneous/QueryKthSmallestTrimmedNumber.java) ||O(n<sup>2</sup>)||
|  50  |Reach The Target|[GFG](https://practice.geeksforgeeks.org/problems/reach-the-target/0) |[Java](./Miscellaneous/ReachTheTarget.java) |Easy|O(n)||
|  51  |Replace By X|[GFG](https://practice.geeksforgeeks.org/problems/replace-by-x/0) |[Java](./Miscellaneous/ReplaceByX.java) |Easy|O(n)||
|  52  |Replace Every Element With The Least Greater Element On Its Right|[GFG](https://practice.geeksforgeeks.org/problems/replace-every-element-with-the-least-greater-element-on-its-right/1/) |[Java](./Miscellaneous/ReplaceEveryElementWithTheLeastGreaterElementOnItsRight.java) |Hard|O(n)||
|  53  |Shortest Subarray To Be Removed To Make Array Sorted|[LC](https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/submissions/) |[Java](./Miscellaneous/RemoveShortesSubarray.java) ||O(n)||
|  54  |Slowest Key|[LC](https://leetcode.com/problems/slowest-key/) |[Java](./Miscellaneous/SlowestKey.java) ||O(n)||
|  55  |Smallest Factorial Number5929|[GFG](https://practice.geeksforgeeks.org/problems/smallest-factorial-number5929/1) |[CPP](./Miscellaneous/GFG_Misc_SmallestFactorialNum.cpp) [Java](./Miscellaneous/SmallestFactorialNumber.java) |Easy|O(1)||
|  56  |Smallest Number In Infinite Set|[LC](https://leetcode.com/problems/smallest-number-in-infinite-set/) |[Java](./Miscellaneous/SmallestNumberInInfiniteSet.java) ||O(n)||
|  57  |Sorting Elements Of An Array By Frequency 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1) |[Java](./Miscellaneous/SortByFrequency.java) |Medium|O(n<sup>2</sup>)||
|  58  |Substring With Concatenation Of All Words|[LC](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) |[Java](./Miscellaneous/SubstringWithConcatenationOfAllWords.java) ||O(n<sup>2</sup>)||
|  59  |Sum Of Numbers With Units Digit K|[LC](https://leetcode.com/problems/sum-of-numbers-with-units-digit-k/) |[Java](./Miscellaneous/SumOfNumbersWithUnitsDigitK.java) ||O(n)||
|  60  |Sum Of Square Numbers|[LC](https://leetcode.com/problems/sum-of-square-numbers/) |[Java](./Miscellaneous/SumOfSquareNumbers.java) ||O(n<sup>2</sup>)||
|  61  |Sum Of Two Numbers Without Using Arithmetic Operators|[GFG](https://practice.geeksforgeeks.org/problems/sum-of-two-numbers-without-using-arithmetic-operators/1/#) |[CPP](./Miscellaneous/GFG_Misc_SumWithoutArithmeticOperators.cpp) |Easy|O(1)||
|  62  |The Latest Time To Catch A Bus|[LC](https://leetcode.com/problems/the-latest-time-to-catch-a-bus/) |[Java](./Miscellaneous/LatestTimeToCatchABus.java) ||O(n<sup>2</sup>)||
|  63  |Two Furthest Houses With Different Colors|[LC](https://leetcode.com/problems/two-furthest-houses-with-different-colors/) |[Java](./Miscellaneous/TwoFurthestHousesWithDifferentColors.java) ||O(n<sup>2</sup>)||
|  64  |Unique Morse Code Words|[LC](https://leetcode.com/problems/unique-morse-code-words/) |[Java](./Miscellaneous/MorseCodeParsing.java) ||O(n<sup>2</sup>)||
|  65  |You And Your Books|[GFG](https://practice.geeksforgeeks.org/problems/you-and-your-books/1) |[Java](./Miscellaneous/YourBooks.java) |Easy|O(n)||
|  66  |Zigzag Conversion|[LC](https://leetcode.com/problems/zigzag-conversion/) |[Java](./Miscellaneous/ZigzagConversion.java) ||O(1)||
## Queue

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Binary Tree Level Order Traversal|[LC](https://leetcode.com/problems/binary-tree-level-order-traversal/) [GFG](https://practice.geeksforgeeks.org/problems/level-order-traversal/1/#) |[CPP](./Queue/LC_102_BinaryTreeLevelOrderTraversal.cpp) |Easy|O(1)||
|  2  |Binary Tree Zigzag Level Order Traversal|[LC](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) |[CPP](./Queue/LC_103_BinaryTreeZigZagLevelOrderTraversal.cpp) ||O(1)||
|  3  |Circular Tour 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1) |[Java](./Queue/CircularTour.java) |Medium|O(n)||
|  4  |First Negative Integer In Every Window Of Size K3345|[GFG](https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1/) |[Java](./Queue/FirstNegativeIntegerInEveryWindowOfSizeK.java) |Easy|O(n)||
|  5  |Implement Queue Using Stacks|[LC](https://leetcode.com/problems/implement-queue-using-stacks/) |[CPP](./Queue/GFG_ImplQueueUsingStack.cpp) [Java](./Queue/QueueUsingStack.java) ||O(1)||
|  6  |Lru Cache|[LC](https://leetcode.com/problems/lru-cache/) [GFG](https://practice.geeksforgeeks.org/problems/page-faults-in-lru5603/1) |[Java](./Queue/LRUCache.java) |Medium|O(n)||
|  7  |Maximum Depth Of Binary Tree|[LC](https://leetcode.com/problems/maximum-depth-of-binary-tree/) [GFG](https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1/#) |[CPP](./Queue/LC_104_MaxDepthBinTree.cpp) |Medium|O(1)||
|  8  |Maximum Of All Subarrays Of Size K3101|[GFG](https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1) |[Java](./Queue/MaximumOfAllSubarrays.java) |Medium|O(n)||
|  9  |N Ary Tree Level Order Traversal|[LC](https://leetcode.com/problems/n-ary-tree-level-order-traversal/) |[CPP](./Queue/LC_429_NaryTreeLevelOrderTraversal.cpp) ||O(1)||
|  10  |Sliding Window Maximum|[LC](https://leetcode.com/problems/sliding-window-maximum/) |[Java](./Queue/SlidingWindowMaximum.java) ||O(n<sup>2</sup>)||
|  11  |Validate Binary Search Tree|[LC](https://leetcode.com/problems/validate-binary-search-tree/) |[CPP](./Queue/LC_98_ValidateBST.cpp) ||O(1)||
## Recursion

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Count Nodes In Complete Binary Tree|[BS](https://binarysearch.com/problems/Count-Nodes-in-Complete-Binary-Tree) [LC](https://leetcode.com/problems/count-complete-tree-nodes/) |[CPP](./Recursion/LC_222_CountCompleteTreeNodes.cpp) ||O(1)||
|  2  |Combinations|[LC](https://leetcode.com/problems/combinations/) |[CPP](./Recursion/LC_77_Combinations.cpp) [Java](./Recursion/Combinations.java) ||O(n)||
|  3  |Flood Fill|[LC](https://leetcode.com/problems/flood-fill/) |[CPP](./Recursion/LC_733_FloodFill.cpp) ||O(1)||
|  4  |Flood Fill Algorithm1856|[GFG](https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1) |[Java](./Recursion/FloodFill.java) |Medium|O(1)||
|  5  |Gray Code|[LC](https://leetcode.com/problems/gray-code/) [GFG](https://practice.geeksforgeeks.org/problems/generate-grey-code-sequences/1) |[CPP](./Recursion/LC_89_GrayCode.cpp) [Java](./Recursion/generateGrayCode.java) |Easy|O(n)||
|  6  |Josephus Problem|[GFG](https://practice.geeksforgeeks.org/problems/josephus-problem/1) |[CPP](./Recursion/GFG_JosephusProblem.cpp) [Java](./Recursion/Josephus.java) |Easy|O(1)||
|  7  |Letter Case Permutation|[LC](https://leetcode.com/problems/letter-case-permutation/) |[CPP](./Recursion/LC_784_LetterCasePermutation.cpp) [Java](./Recursion/LetterCasePermutations.java) ||O(1)||
|  8  |Number Of Paths0926|[GFG](https://practice.geeksforgeeks.org/problems/number-of-paths0926/1) |[Java](./Recursion/NumberOfPaths.java) |Easy|O(n)||
|  9  |Palindrome String0817|[GFG](https://practice.geeksforgeeks.org/problems/palindrome-string0817/1) |[CPP](./Recursion/GFG_STR_PalindromeString.cpp) [Java](./Recursion/PalindromeString.java) |Easy|O(1)||
|  10  |Pascals Triangle|[LC](https://leetcode.com/problems/pascals-triangle/) |[CPP](./Recursion/LC_118_PascalTriangle.cpp) [Java](./Recursion/PascalsTriangle.java) ||O(1)||
|  11  |Pascals Triangle Ii|[LC](https://leetcode.com/problems/pascals-triangle-ii/) |[CPP](./Recursion/LC_119_PascalsTriangleII.cpp) [Java](./Recursion/PascalsTriangle2.java) ||O(1)||
|  12  |Permutations Of A Given String2041|[GFG](https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1/#) |[CPP](./Recursion/GFG_PermutationsOfGivenString.cpp) |Medium|O(1)||
|  13  |Power Set4302|[GFG](https://practice.geeksforgeeks.org/problems/power-set4302/1) |[Java](./Recursion/PowerSet.java) |Easy|O(1)||
|  14  |Restore Ip Addresses|[LC](https://leetcode.com/problems/restore-ip-addresses/) [GFG](https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1) |[Java](./Recursion/RestoreIPAddresses.java) |Medium|O(1)||
|  15  |Subsets|[LC](https://leetcode.com/problems/subsets/) |[CPP](./Recursion/LC_78_Subsets.cpp) [Java](./Recursion/Subsets.java) ||O(1)||
|  16  |Tower Of Hanoi 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1#) |[CPP](./Recursion/GFG_TowerOfHanoi.cpp) [Java](./Recursion/TOH.java) |Medium|O(1)||
## Searching

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |3d27d4683c121c1f152ee8f41279255dc4430cf6|[GFG](https://practice.geeksforgeeks.org/problems/3d27d4683c121c1f152ee8f41279255dc4430cf6/1/#) |[CPP](./Searching/GFG_TernarySearch.cpp) [Java](./Searching/TernarySearch.java) |Medium|O(1)||
|  2  |3sum|[LC](https://leetcode.com/problems/3sum/) |[CPP](./Searching/LC_15_3Sum.cpp) [Java](./Searching/FindTripletsWithGivenSum.java) ||O(n<sup>3</sup>)||
|  3  |3sum Closest|[LC](https://leetcode.com/problems/3sum-closest/) |[CPP](./Searching/LC_16_3SumClosest.cpp) [Java](./Searching/TripletWithSumClosestToGivenSum.java) ||O(1)||
|  4  |4sum|[LC](https://leetcode.com/problems/4sum/) |[CPP](./Searching/LC_18_4Sum.cpp) [Java](./Searching/CountQuadrupletsWithGivenSum.java) ||O(n<sup>4</sup>)||
|  5  |Insertion Index In Sorted List|[BS](https://binarysearch.com/problems/Insertion-Index-in-Sorted-List) [GFG](https://practice.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1/) |[Java](./Searching/SearchInsertPosition.java) |Easy|O(1)||
|  6  |Lowest Sum Of Pair Larger Than Target|[BS](https://binarysearch.com/problems/Lowest-Sum-of-Pair-Larger-than-Target) |[Java](./Searching/LowestSumOfPairLargerThanTarget.java) ||O(n<sup>2</sup>)||
|  7  |Allocate Minimum Number Of Pages0937|[GFG](https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1/) |[Java](./Searching/AllocateMinimumNumberOfPages.java) |Hard|O(n)||
|  8  |Arithmetic Number2815|[GFG](https://practice.geeksforgeeks.org/problems/arithmetic-number2815/1) |[CPP](./Searching/GFG_FindPresenceInAP_ArithmeticNumber.cpp) [Java](./Searching/FindPresenceInAP.java) |Easy|O(1)||
|  9  |Arithmetic Subarrays|[LC](https://leetcode.com/problems/arithmetic-subarrays/) |[CPP](./Searching/LC_1630_ArithmeticSubarrays.cpp) ||O(1)||
|  10  |Binary Search|[GFG](https://practice.geeksforgeeks.org/problems/binary-search/1#) |[CPP](./Searching/GFG_BinarySearch.cpp) |Basic|O(1)||
|  11  |Capacity To Ship Packages Within D Days|[LC](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) [GFG](https://practice.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1) |[Java](./Searching/CapacityToShipPackagesWithinDDays.java) |Medium|O(n)||
|  12  |Convert Sorted Array To Binary Search Tree|[LC](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) |[Java](./Searching/ConvertSortedArrayToBinarySearchTree.java) ||O(n)||
|  13  |Convert Sorted List To Binary Search Tree|[LC](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/) |[Java](./Searching/ConvertSortedListToBinarySearchTree.java) ||O(n)||
|  14  |Count Of Smaller Numbers After Self|[LC](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) |[Java](./Searching/CountOfSmallerNumbersAfterSelf.java) ||O(n)||
|  15  |Count Pairs With Given Sum5022|[GFG](https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#) |[CPP](./Searching/GFG_CountPairsWithGivenSum.cpp) |Easy|O(1)||
|  16  |Count Possible Triangles 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1/) |[CPP](./Searching/GFG_CountNumOfPossibleTriangles.cpp) [Java](./Searching/CountTriangles.java) |Medium|O(n<sup>3</sup>)||
|  17  |Count The Zeros2550|[GFG](https://practice.geeksforgeeks.org/problems/count-the-zeros2550/1) |[CPP](./Searching/GFG_Count_NumOfOnes.cpp) |Easy|O(1)||
|  18  |Count Triplets With Sum Smaller Than X5549|[GFG](https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1) |[CPP](./Searching/GFG_TripletsSumSmallerThanX.cpp) [Java](./Searching/CountTripletsWithSumSmallerThanX.java) |Medium|O(n<sup>2</sup>)||
|  19  |Find First And Last Position Of Element In Sorted Array|[LC](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) |[CPP](./Searching/LC_34_FindFirstLastPositionElement.cpp) [Java](./Searching/FirstAndLastPositions.java) ||O(1)||
|  20  |Find K Closest Elements|[LC](https://leetcode.com/problems/find-k-closest-elements/) |[CPP](./Searching/LC_658_FindKClosestElements.cpp) [Java](./Searching/FindKClosestElements.java) ||O(n)||
|  21  |Find Missing And Repeating2512|[GFG](https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1) |[CPP](./Searching/GFG_FindRepeatingAndMissing.cpp) [Java](./Searching/FindRepeatingMissing.java) |Medium|O(n)||
|  22  |Find Pair Given Difference1559|[GFG](https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1) |[CPP](./Searching/GFG_FindPairGivenDifference.cpp) [Java](./Searching/FindPairWithGivenDifference.java) |Easy|O(n)||
|  23  |Find The Smallest Divisor Given A Threshold|[LC](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/) |[Java](./Searching/FindTheSmallestDivisorGivenAThreshold.java) ||O(n)||
|  24  |First Bad Version|[LC](https://leetcode.com/problems/first-bad-version/) |[CPP](./Searching/LC_278_FirstBadVersion.cpp) [Java](./Searching/FirstBadVersion.java) ||O(n)||
|  25  |Four Elements2452|[GFG](https://practice.geeksforgeeks.org/problems/four-elements2452/1#) |[CPP](./Searching/GFG_FourElementsSum.cpp) [Java](./Searching/QuadrupletsWithGivenSum.java) |Easy|O(1)||
|  26  |Guess Number Higher Or Lower|[LC](https://leetcode.com/problems/guess-number-higher-or-lower/) |[CPP](./Searching/LC_374_GuessNumHigherOrLower.cpp) [Java](./Searching/GuessHigherLower.java) ||O(n)||
|  27  |K Diff Pairs In An Array|[LC](https://leetcode.com/problems/k-diff-pairs-in-an-array/) |[CPP](./Searching/LC_532_KdiffPairsinArray.cpp) [Java](./Searching/CountKDiffUniquePairs.java) ||O(n)||
|  28  |K Th Element Of Two Sorted Array1317|[GFG](https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1#) |[CPP](./Searching/GFG_KthEleOfTwoSortedArrays.cpp) |Medium|O(1)||
|  29  |Kth Smallest Number In Multiplication Table|[LC](https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/) |[CPP](./Searching/LC_668_KthSmallestNumberInMultiplication.cpp) [Java](./Searching/KthSmallestInMultiplicationTable.java) ||O(n)||
|  30  |Last Day Where You Can Still Cross|[LC](https://leetcode.com/problems/last-day-where-you-can-still-cross/) |[Java](./Searching/LastDayWhereYouCanStillCross.java) ||O(n<sup>2</sup>)||
|  31  |Maximum Distance Between A Pair Of Values|[LC](https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/) |[Java](./Searching/MaximumDistanceBetweenAPairOfValues.java) ||O(n)||
|  32  |Maximum Value In A Bitonic Array3001|[GFG](https://practice.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1/) |[Java](./Searching/BitonicPoint.java) |Easy|O(n)||
|  33  |Minimum Element In A Sorted And Rotated Array3611|[GFG](https://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1/) |[Java](./Searching/MinimumElementInASortedAndRotatedArray.java) |Easy|O(n)||
|  34  |Minimum Limit Of Balls In A Bag|[LC](https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/) |[Java](./Searching/MinimumLimitOfBallsInABag.java) ||O(n)||
|  35  |Number Of Pairs 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/number-of-pairs-1587115620/1/) |[Java](./Searching/NumberOfPairs.java) |Medium|O(n)||
|  36  |Pair With Given Sum In A Sorted Array4940|[GFG](https://practice.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1) |[CPP](./Searching/GFG_PairWithGivenSumInSortedArray.cpp) [Java](./Searching/CountPairSumInSortedArray.java) |Easy|O(n)||
|  37  |Search In Rotated Sorted Array|[LC](https://leetcode.com/problems/search-in-rotated-sorted-array/) |[CPP](./Searching/LC_33_SearchRotatedSortedArray.cpp) [Java](./Searching/SortedRotatedArraySearch.java) ||O(1)||
|  38  |Search Insert Position Of K In A Sorted Array|[GFG](https://practice.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1/#) |[CPP](./Searching/GFG_SearchInsertPosInSortedArray.cpp) |Easy|O(1)||
|  39  |Searching In An Array Where Adjacent Differ By At Most K0456|[GFG](https://practice.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-differ-by-at-most-k0456/1/#) |[CPP](./Searching/GFG_SearchWhereAdjDifferAtmostK.cpp) |Easy|O(1)||
|  40  |Sqrtx|[LC](https://leetcode.com/problems/sqrtx/) [GFG](https://practice.geeksforgeeks.org/problems/square-root/1/) |[CPP](./Searching/LC_64_Sqrt_GFG_Sqrt.cpp) [Java](./Searching/FindSquareRoot.java) |Medium|O(1)||
|  41  |Successful Pairs Of Spells And Potions|[LC](https://leetcode.com/problems/successful-pairs-of-spells-and-potions/) |[Java](./Searching/SuccessfulPairsOfSpellsAndPotions.java) ||O(1)||
|  42  |The Painters Partition Problem1535|[GFG](https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1/) |[Java](./Searching/PaintersPartitionProblem2.java) |Hard|O(n<sup>3</sup>)||
|  43  |Time Based Key Value Store|[LC](https://leetcode.com/problems/time-based-key-value-store/) |[Java](./Searching/TimeBasedKeyValueStore.java) ||O(n<sup>2</sup>)||
|  44  |Triplet Sum In Array 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1) |[CPP](./Searching/GFG_TripletSum.cpp) [Java](./Searching/TripletWithGivenSum.java) |Medium|O(1)||
|  45  |Triplets With Sum With Given Range|[GFG](https://practice.geeksforgeeks.org/problems/triplets-with-sum-with-given-range/1/) |[CPP](./Searching/GFG_TripletSumWithGivenRange.cpp) [Java](./Searching/CountTripletsWithSumInRange.java) |Medium|O(n<sup>2</sup>)||
|  46  |Two Sum|[LC](https://leetcode.com/problems/two-sum/) |[CPP](./Searching/LC_1_TwoSum.cpp) [Java](./Searching/PairWithSum.java) ||O(1)||
|  47  |Two Sum Ii Input Array Is Sorted|[LC](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) |[CPP](./Searching/LC_167_TwoSumII.cpp) [Java](./Searching/PairWithSumInSortedArray.java) ||O(1)||
## Segment-Tree

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Range Sum Query Immutable|[LC](https://leetcode.com/problems/range-sum-query-immutable/) |[Java](./Segment-Tree/RangeSumQueryImmutable.java) ||O(n)||
|  2  |Range Sum Query Mutable|[LC](https://leetcode.com/problems/range-sum-query-mutable/) |[Java](./Segment-Tree/RangeSumQueryMutable.java) ||O(n)||
## Sorting

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |850|[LC2](https://www.lintcode.com/problem/850/) |[Java](./Sorting/EmployeeFreeTime.java) ||O(n<sup>2</sup>)||
|  2  |920|[LC2](https://www.lintcode.com/problem/920/) |[Java](./Sorting/MeetingRooms.java) ||O(n)||
|  3  |Activity Selection 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1/) |[Java](./Sorting/ActivitySelection.java) |Easy|O(n)||
|  4  |Arithmetic Subarrays|[LC](https://leetcode.com/problems/arithmetic-subarrays/) |[Java](./Sorting/ArithmeticSubArrays.java) ||O(n<sup>3</sup>)||
|  5  |Bubble Sort|[GFG](https://practice.geeksforgeeks.org/problems/bubble-sort/1) |[CPP](./Sorting/GFG_BubbleSort.cpp) [Java](./Sorting/BubbleSort.java) |Easy|O(n<sup>2</sup>)||
|  6  |Counting Sort|[GFG](https://practice.geeksforgeeks.org/problems/counting-sort/1) |[CPP](./Sorting/GFG_CountingSort.cpp) [Java](./Sorting/CountingSort.java) |Easy|O(n<sup>2</sup>)||
|  7  |Find All Pairs Whose Sum Is X5808|[GFG](https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/1/) |[Java](./Sorting/FindAllPairsWithAGivenSum.java) |Easy|O(n)||
|  8  |Heap Sort|[GFG](https://practice.geeksforgeeks.org/problems/heap-sort/1) |[CPP](./Sorting/GFG_HeapSort.cpp) [Java](./Sorting/HeapSort.java) |Medium|O(1)||
|  9  |Insertion Sort|[GFG](https://practice.geeksforgeeks.org/problems/insertion-sort/1#) |[CPP](./Sorting/GFG_InsertionSort.cpp) [Java](./Sorting/InsertionSort.java) |Easy|O(1)||
|  10  |Merge Sort|[GFG](https://practice.geeksforgeeks.org/problems/merge-sort/1) |[CPP](./Sorting/GFG_MergeSort.cpp) [Java](./Sorting/MergeSort.java) |Medium|O(1)||
|  11  |Nearly Sorted Algorithm|[GFG](https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0) |[Java](./Sorting/NearlySortedAlgorithm.java) |Medium|O(n<sup>2</sup>)||
|  12  |Quick Sort|[GFG](https://practice.geeksforgeeks.org/problems/quick-sort/1) |[CPP](./Sorting/GFG_QuickSort.cpp) [Java](./Sorting/QuickSort.java) |Medium|O(1)||
|  13  |Selection Sort|[GFG](https://practice.geeksforgeeks.org/problems/selection-sort/1#) |[CPP](./Sorting/GFG_SelectionSort.cpp) [Java](./Sorting/SelectionSort.java) |Easy|O(n<sup>2</sup>)||
## Stack

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Circular Greater Element To The Right|[BS](https://binarysearch.com/problems/Circular-Greater-Element-to-the-Right) [LC](https://leetcode.com/problems/next-greater-element-ii/) |[Java](./Stack/NextGreaterElementCircular.java) ||O(n<sup>2</sup>)||
|  2  |Count The Reversals0401|[GFG](https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1) |[Java](./Stack/CountTheReversals.java) |Medium|O(n)||
|  3  |Daily Temperatures|[LC](https://leetcode.com/problems/daily-temperatures/) |[Java](./Stack/DailyTemperatures.java) ||O(n<sup>2</sup>)||
|  4  |Decode The String2444|[GFG](https://practice.geeksforgeeks.org/problems/decode-the-string2444/1) |[Java](./Stack/DecodeString.java) |Easy|O(n)||
|  5  |Design A Stack With Increment Operation|[LC](https://leetcode.com/problems/design-a-stack-with-increment-operation/) |[Java](./Stack/StackWithIncrementOperation.java) ||O(n<sup>2</sup>)||
|  6  |Evaluate Reverse Polish Notation|[LC](https://leetcode.com/problems/evaluate-reverse-polish-notation/) |[CPP](./Stack/GFG_LC_EvaluationOfPostFix.cpp) [Java](./Stack/PostfixEvaluation.java) ||O(1)||
|  7  |Fab3dbbdce746976ba35c7b9b24afde40eae5a04|[GFG](https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1) |[Java](./Stack/HelpClassmates.java) |Medium|O(n<sup>2</sup>)||
|  8  |Implement Stack Using Array|[GFG](https://practice.geeksforgeeks.org/problems/implement-stack-using-array/1) |[CPP](./Stack/StackUsingArrayImplementation.cpp) |Basic|O(1)||
|  9  |Implement Stack Using Linked List|[GFG](https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1) |[CPP](./Stack/StackUsingLinkListImplementation.cpp) |Basic|O(1)||
|  10  |Implement Stack Using Queues|[LC](https://leetcode.com/problems/implement-stack-using-queues/) |[Java](./Stack/StackUsingQueue.java) ||O(n)||
|  11  |Implement Two Stacks In An Array|[GFG](https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1) |[Java](./Stack/TwoStacksInOneArray.java) |Easy|O(n)||
|  12  |Infix To Postfix 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1#) |[CPP](./Stack/GFG_InfxToPostFix.cpp) [Java](./Stack/InfixToPostfix.java) |Easy|O(1)||
|  13  |Largest Rectangle In Histogram|[LC](https://leetcode.com/problems/largest-rectangle-in-histogram/) [GFG](https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1) |[Java](./Stack/LargestRectangleInHistogram.java) |Medium|O(n)||
|  14  |Longest Valid Parentheses|[LC](https://leetcode.com/problems/longest-valid-parentheses/) |[Java](./Stack/ValidParenthesesSubstring.java) ||O(n)||
|  15  |Maximum Of Minimum For Every Window Size3453|[GFG](https://practice.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1#) |[Java](./Stack/MaxOfMins.java) |Hard|O(n<sup>2</sup>)||
|  16  |Min Stack|[LC](https://leetcode.com/problems/min-stack/) [GFG](https://practice.geeksforgeeks.org/problems/special-stack/1) |[Java](./Stack/StackWithFindMin.java) |Easy|O(n)||
|  17  |Minimum Swaps For Bracket Balancing2704|[GFG](https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1) |[Java](./Stack/MinimumSwapsForBracketBalancing.java) |Easy|O(n<sup>2</sup>)||
|  18  |Next Greater Element I|[LC](https://leetcode.com/problems/next-greater-element-i/) |[CPP](./Stack/LC_469_NextGreaterEle1.cpp) [Java](./Stack/NextGreaterElement.java) ||O(1)||
|  19  |Number Of Visible People In A Queue|[LC](https://leetcode.com/problems/number-of-visible-people-in-a-queue/) |[Java](./Stack/NumberOfVisiblePeopleInAQueue.java) ||O(n<sup>2</sup>)||
|  20  |Online Stock Span|[LC](https://leetcode.com/problems/online-stock-span/) |[Java](./Stack/OnlineStockSpanProblem.java) ||O(n)||
|  21  |Simplify Path|[LC](https://leetcode.com/problems/simplify-path/) |[Java](./Stack/ParsePath.java) ||O(n)||
|  22  |Sort A Stack|[GFG](https://practice.geeksforgeeks.org/problems/sort-a-stack/1) |[Java](./Stack/SortStack.java) |Easy|O(n<sup>2</sup>)||
|  23  |Stack Permutations|[GFG](https://practice.geeksforgeeks.org/problems/stack-permutations/1/) |[Java](./Stack/StackPermutations.java) |Medium|O(n<sup>2</sup>)||
|  24  |Stock Span Problem 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1#) |[CPP](./Stack/GFG_StockSpanP.cpp) [Java](./Stack/StockSpanProblem.java) |Medium|O(1)||
|  25  |The Celebrity Problem|[GFG](https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1) |[Java](./Stack/CelebrityProblem.java) |Medium|O(n<sup>2</sup>)||
|  26  |Valid Parentheses|[LC](https://leetcode.com/problems/valid-parentheses/) |[CPP](./Stack/LC_20_ValidParentheses.cpp) [Java](./Stack/ValidParentheses.java) ||O(1)||
## Strings

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |31272eef104840f7430ad9fd1d43b434a4b9596b|[GFG](https://practice.geeksforgeeks.org/problems/31272eef104840f7430ad9fd1d43b434a4b9596b/1/) |[Java](./Strings/RabinKarp.java) |null|O(n<sup>2</sup>)||
|  2  |856|[LC2](https://www.lintcode.com/problem/856/description) |[Java](./Strings/SentenceSimilarity.java) ||O(n)||
|  3  |927|[LC2](https://www.lintcode.com/problem/927/) |[Java](./Strings/ReverseWordsInAString2.java) ||O(n)||
|  4  |Add Binary Numbers|[BS](https://binarysearch.com/problems/Add-Binary-Numbers) |[Java](./Strings/AddBinaryNumbers.java) ||O(n)||
|  5  |Bulk Shift Letters|[BS](https://binarysearch.com/problems/Bulk-Shift-Letters) |[Java](./Strings/BulkShiftLetters.java) ||O(n)||
|  6  |Largest Anagram Group|[BS](https://binarysearch.com/problems/Largest-Anagram-Group) |[Java](./Strings/LargestAnagramGroup.java) ||O(n)||
|  7  |Lexicographically Smallest Non Palindromic String|[BS](https://binarysearch.com/problems/Lexicographically-Smallest-Non-Palindromic-String) [LC](https://leetcode.com/problems/break-a-palindrome/) |[Java](./Strings/LexicographicallySmallestNonPalindromicString.java) ||O(n)||
|  8  |Lexicographically Smallest String Of Distance K|[BS](https://binarysearch.com/problems/Lexicographically-Smallest-String-of-Distance-K) |[Java](./Strings/LexicographicallySmallestStringOfDistanceK.java) ||O(n)||
|  9  |Longest 1s After One Flip|[BS](https://binarysearch.com/problems/Longest-1s-After-One-Flip) |[Java](./Strings/LongestOnesAfterOneFlip.java) ||O(n<sup>2</sup>)||
|  10  |Sentence Reversal|[BS](https://binarysearch.com/problems/Sentence-Reversal) |[CPP](./Strings/BS_SentenceReversal.cpp) ||O(1)||
|  11  |Subsequence Strings|[BS](https://binarysearch.com/problems/Subsequence-Strings) |[Java](./Strings/SubsequenceStrings.java) ||O(n)||
|  12  |Consecutive Characters|[LC](https://leetcode.com/problems/consecutive-characters/) |[CPP](./Strings/LC_1446_STR_Consecutive_Characters.cpp) [Java](./Strings/ConsecutiveCharacters.java) ||O(n)||
|  13  |Count And Say|[LC](https://leetcode.com/problems/count-and-say/) |[Java](./Strings/CountAndSay.java) ||O(n<sup>2</sup>)||
|  14  |Count Number Of Homogenous Substrings|[LC](https://leetcode.com/problems/count-number-of-homogenous-substrings/) |[CPP](./Strings/LC_1759_STR_CountNumOfHomogenousSubstring.cpp) [Java](./Strings/CountHomogeneousSubstrings.java) ||O(n)||
|  15  |Count Number Of Substrings4528|[GFG](https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/1) |[Java](./Strings/CountNumberOfSubstrings.java) |null|O(n<sup>2</sup>)||
|  16  |Count Palindrome Sub Strings Of A String0652|[GFG](https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string0652/1/) |[Java](./Strings/CountPalindromeSubstringsOfAString.java) |Medium|O(n)||
|  17  |Count Substrings That Differ By One Character|[LC](https://leetcode.com/problems/count-substrings-that-differ-by-one-character/) |[Java](./Strings/CountSubstringsThatDifferByOneCharacter.java) ||O(n<sup>3</sup>)||
|  18  |Count Words Obtained After Adding A Letter|[LC](https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/) |[Java](./Strings/CountWordsObtainedAfterAddingALetter.java) ||O(n<sup>2</sup>)||
|  19  |Custom Sort String|[LC](https://leetcode.com/problems/custom-sort-string/) |[Java](./Strings/CustomSortString.java) ||O(n<sup>2</sup>)||
|  20  |Decode String|[LC](https://leetcode.com/problems/decode-string/) |[Java](./Strings/DecodeString.java) ||O(n)||
|  21  |Decode The Message|[LC](https://leetcode.com/problems/decode-the-message/) |[Java](./Strings/DecodeTheMessage.java) ||O(n)||
|  22  |Delete Operation For Two Strings|[LC](https://leetcode.com/problems/delete-operation-for-two-strings/) |[Java](./Strings/DeleteOperationForTwoStrings.java) ||O(n<sup>2</sup>)||
|  23  |Design A Text Editor|[LC](https://leetcode.com/problems/design-a-text-editor/) |[Java](./Strings/DesignATextEditor.java) ||O(n)||
|  24  |Distinct Palindromic Substrings5141|[GFG](https://practice.geeksforgeeks.org/problems/distinct-palindromic-substrings5141/1/) |[Java](./Strings/DistinctPalindromicSubstrings.java) |Hard|O(n)||
|  25  |Find All Anagrams In A String|[LC](https://leetcode.com/problems/find-all-anagrams-in-a-string/) |[CPP](./Strings/LC_438_FindAllAnagramsString.cpp) [Java](./Strings/AnagramSearch.java) ||O(n<sup>2</sup>)||
|  26  |Find First Repeated Character4108|[GFG](https://practice.geeksforgeeks.org/problems/find-first-repeated-character4108/1/) |[CPP](./Strings/GFG_FirstRepeatedChar.cpp) |Basic|O(1)||
|  27  |Find The Missing No In String|[GFG](https://practice.geeksforgeeks.org/problems/find-the-missing-no-in-string/1) |[Java](./Strings/FindTheMissingNoInString.java) |null|O(n<sup>2</sup>)||
|  28  |First Letter To Appear Twice|[LC](https://leetcode.com/problems/first-letter-to-appear-twice/) |[Java](./Strings/FirstLetterToAppearTwice.java) ||O(n)||
|  29  |First Non Repeating Character In A Stream1216|[GFG](https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1) |[Java](./Strings/FirstUniqueCharacterInAStream.java) |Medium|O(n<sup>2</sup>)||
|  30  |First Unique Character In A String|[LC](https://leetcode.com/problems/first-unique-character-in-a-string/) |[CPP](./Strings/GFG_NonRepeatingChar.cpp) [Java](./Strings/FirstUniqueCharacter.java) ||O(n)||
|  31  |Get Equal Substrings Within Budget|[LC](https://leetcode.com/problems/get-equal-substrings-within-budget/) |[Java](./Strings/GetEqualSubstringsWithinBudget.java) ||O(n)||
|  32  |Goat Latin|[LC](https://leetcode.com/problems/goat-latin/) |[Java](./Strings/GoatLatin.java) ||O(n)||
|  33  |Greatest English Letter In Upper And Lower Case|[LC](https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/) |[Java](./Strings/GreatestEnglishLetterInUpperAndLowerCase.java) ||O(n)||
|  34  |Implement Atoi|[GFG](https://practice.geeksforgeeks.org/problems/implement-atoi/1) |[CPP](./Strings/GFG_ImplementAtoi.cpp) [Java](./Strings/Atoi.java) |Medium|O(n)||
|  35  |Isomorphic Strings|[LC](https://leetcode.com/problems/isomorphic-strings/) [GFG](https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1) |[Java](./Strings/IsomorphicStrings.java) |Easy|O(n)||
|  36  |Longest Chunked Palindrome Decomposition|[LC](https://leetcode.com/problems/longest-chunked-palindrome-decomposition/) |[Java](./Strings/LongestChunkedPalindromeDecomposition.java) ||O(n)||
|  37  |Longest Even Length Substring|[GFG](https://practice.geeksforgeeks.org/problems/longest-even-length-substring/0) |[Java](./Strings/LongestEvenLengthSubstring.java) |Medium|O(n<sup>3</sup>)||
|  38  |Longest Happy String|[LC](https://leetcode.com/problems/longest-happy-string/) |[Java](./Strings/LongestHappyString.java) ||O(n)||
|  39  |Longest K Unique Characters Substring0853|[GFG](https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/) |[Java](./Strings/LongestKUniqueCharacters.java) |Easy|O(n<sup>2</sup>)||
|  40  |Longest Palindrome|[LC](https://leetcode.com/problems/longest-palindrome/) |[Java](./Strings/LongestPalindrome.java) ||O(n)||
|  41  |Longest Prefix Suffix2527|[GFG](https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1) |[Java](./Strings/LongestPrefixSuffix.java) |Medium|O(n)||
|  42  |Longest String Chain|[LC](https://leetcode.com/problems/longest-string-chain/) |[Java](./Strings/LongestStringChain.java) ||O(n)||
|  43  |Longest Substring With At Least K Repeating Characters|[LC](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/submissions/) |[Java](./Strings/LongestSubstringWithAtLeastKRepeatingCharacters.java) ||O(n<sup>2</sup>)||
|  44  |Match Substring After Replacement|[LC](https://leetcode.com/problems/match-substring-after-replacement/) |[Java](./Strings/MatchSubstringAfterReplacement.java) ||O(n<sup>2</sup>)||
|  45  |Maximize Number Of Subsequences In A String|[LC](https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/) |[Java](./Strings/MaximizeNumberOfSubsequencesInAString.java) ||O(n)||
|  46  |Maximum Length Of A Concatenated String With Unique Characters|[LC](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/) |[Java](./Strings/MaximumLengthOfAConcatenatedStringWithUniqueCharacters.java) ||O(n)||
|  47  |Maximum Number Of Vowels In A Substring Of Given Length|[LC](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/) |[CPP](./Strings/LC_1456_MaxVowelsInSubString.cpp) [Java](./Strings/MaximumNumberOfVowelsInASubstringOfGivenLength.java) ||O(1)||
|  48  |Maximum Product Of Word Lengths|[LC](https://leetcode.com/problems/maximum-product-of-word-lengths/) |[Java](./Strings/MaximumProductOfWordLengths.java) ||O(n<sup>2</sup>)||
|  49  |Minimum Changes To Make Alternating Binary String|[LC](https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/) |[Java](./Strings/MinimumChangesToMakeAlternatingBinaryString.java) ||O(n)||
|  50  |Minimum Indexed Character 1587115620|[GFG](https://practice.geeksforgeeks.org/problems/minimum-indexed-character-1587115620/1/) |[Java](./Strings/MinimumIndexedCharacter.java) |Easy|O(n)||
|  51  |Minimum Length Of String After Deleting Similar Ends|[LC](https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/) |[Java](./Strings/MinimumLengthOfStringAfterDeletingSimilarEnds.java) ||O(n<sup>2</sup>)||
|  52  |Minimum Number Of Frogs Croaking|[LC](https://leetcode.com/problems/minimum-number-of-frogs-croaking/) |[Java](./Strings/MinimumNumberOfFrogsCroaking.java) ||O(n)||
|  53  |Minimum Remove To Make Valid Parentheses|[LC](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/) |[Java](./Strings/MinimumRemoveToMakeValidParentheses.java) ||O(n)||
|  54  |Minimum Window Substring|[LC](https://leetcode.com/problems/minimum-window-substring/) [GFG](https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1) |[Java](./Strings/MinimumWindowSubstring.java) |Medium|O(n<sup>2</sup>)||
|  55  |Move Pieces To Obtain A String|[LC](https://leetcode.com/problems/move-pieces-to-obtain-a-string/) |[Java](./Strings/MovePiecesToObtainAString.java) ||O(n<sup>2</sup>)||
|  56  |Multiply Strings|[LC](https://leetcode.com/problems/multiply-strings) |[Java](./Strings/MultiplyStrings.java) ||O(n<sup>2</sup>)||
|  57  |Number Of Matching Subsequences|[LC](https://leetcode.com/problems/number-of-matching-subsequences/) |[Java](./Strings/NumberOfMatchingSubsequences.java) ||O(n<sup>2</sup>)||
|  58  |Number Of Substrings Containing All Three Characters|[LC](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/) |[Java](./Strings/NumberOfSubstringsContainingAllThreeCharacters.java) ||O(n<sup>2</sup>)||
|  59  |Number Of Substrings With Only 1s|[LC](https://leetcode.com/problems/number-of-substrings-with-only-1s/) |[Java](./Strings/CountConsecutiveOnes.java) ||O(n)||
|  60  |Palindrome Pairs|[LC](https://leetcode.com/problems/palindrome-pairs/) |[Java](./Strings/PalindromePairs.java) ||O(n)||
|  61  |Palindrome String0817|[GFG](https://practice.geeksforgeeks.org/problems/palindrome-string0817/1) |[CPP](./Strings/GFG_STR_PalindromeString.cpp) |Easy|O(1)||
|  62  |Permutation In String|[LC](https://leetcode.com/problems/permutation-in-string/) |[Java](./Strings/PermutationInStrings.java) ||O(n)||
|  63  |Rearrange Characters4649|[GFG](https://practice.geeksforgeeks.org/problems/rearrange-characters4649/1) |[Java](./Strings/RearrangeCharacters.java) |Medium|O(n<sup>2</sup>)||
|  64  |Rearrange Spaces Between Words|[LC](https://leetcode.com/problems/rearrange-spaces-between-words/) |[CPP](./Strings/LC_1592_STR_RearrangeSpaceBwWords.cpp) [Java](./Strings/RearrangeSpaces.java) ||O(1)||
|  65  |Remove All Duplicates From A Given String4321|[GFG](https://practice.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1/) |[Java](./Strings/RemoveAllDuplicatesFromAGivenString.java) |Easy|O(n)||
|  66  |Reorder Data In Log Files|[LC](https://leetcode.com/problems/reorder-data-in-log-files/) |[Java](./Strings/ReorderDataInLogFiles.java) ||O(1)||
|  67  |Reorganize String|[LC](https://leetcode.com/problems/reorganize-string/) |[Java](./Strings/ReorganizeString.java) ||O(n)||
|  68  |Repetition Of K Length Substring|[GFG](https://practice.geeksforgeeks.org/problems/repetition-of-k-length-substring/1) |[Java](./Strings/RepititionOfKLengthSubstring.java) |Easy|O(n)||
|  69  |Replace The Substring For Balanced String|[LC](https://leetcode.com/problems/replace-the-substring-for-balanced-string/) |[Java](./Strings/ReplaceTheSubstringForBalancedString.java) ||O(n<sup>2</sup>)||
|  70  |Reverse A String|[GFG](https://practice.geeksforgeeks.org/problems/reverse-a-string/1#) |[CPP](./Strings/GFG_STR_ReverseString.cpp) |Basic|O(1)||
|  71  |Reverse Vowels Of A String|[LC](https://leetcode.com/problems/reverse-vowels-of-a-string/) |[Java](./Strings/ReverseVowelsOfAString.java) ||O(n<sup>2</sup>)||
|  72  |Rotate String|[LC](https://leetcode.com/problems/rotate-string/) |[CPP](./Strings/LC_796_RotateString.cpp) [Java](./Strings/StringRotationCheck.java) ||O(1)||
|  73  |Run Length Encoding|[GFG](https://practice.geeksforgeeks.org/problems/run-length-encoding/1) |[Java](./Strings/RunLengthEncoding.java) |Easy|O(n)||
|  74  |Score Of Parentheses|[LC](https://leetcode.com/problems/score-of-parentheses/) |[Java](./Strings/ScoreOfParentheses.java) ||O(n<sup>2</sup>)||
|  75  |Search Pattern0205|[GFG](https://practice.geeksforgeeks.org/problems/search-pattern0205/1) |[Java](./Strings/KMP.java) |null|O(n)||
|  76  |Sentence Similarity Iii|[LC](https://leetcode.com/problems/sentence-similarity-iii/) |[Java](./Strings/SentenceSimilarity3.java) ||O(n)||
|  77  |Sherlock And Anagrams|[HR](https://www.hackerrank.com/challenges/sherlock-and-anagrams/) |[Java](./Strings/SherlockAndAnagrams.java) ||O(n<sup>2</sup>)||
|  78  |Shortest Palindrome|[LC](https://leetcode.com/problems/shortest-palindrome/) |[Java](./Strings/ShortestPalindrome.java) ||O(n<sup>2</sup>)||
|  79  |Smallest Distant Window3132|[GFG](https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1) |[Java](./Strings/SmallestDistinctWindow.java) |Medium|O(n<sup>2</sup>)||
|  80  |Sort Characters By Frequency|[LC](https://leetcode.com/problems/sort-characters-by-frequency/) |[Java](./Strings/SortCharactersByFrequency.java) ||O(n)||
|  81  |Strong Password Checker Ii|[LC](https://leetcode.com/problems/strong-password-checker-ii/) |[Java](./Strings/StrongPasswordChecker2.java) ||O(n)||
|  82  |Substrings Of Length K With K 1 Distinct Elements|[GFG](https://practice.geeksforgeeks.org/problems/substrings-of-length-k-with-k-1-distinct-elements/1#) |[Java](./Strings/SubstringsWithK-1DistinctElements.java) |Medium|O(n)||
|  83  |Text Justification|[LC](https://leetcode.com/problems/text-justification/) |[Java](./Strings/TextJustification.java) ||O(n<sup>3</sup>)||
|  84  |Truncate Sentence|[LC](https://leetcode.com/problems/truncate-sentence/) |[Java](./Strings/TruncateSentence.java) ||O(n)||
|  85  |Uncommon Words From Two Sentences|[LC](https://leetcode.com/problems/uncommon-words-from-two-sentences/) |[CPP](./Strings/LC_884_STR_UncommonWordsFromTwoSentences.cpp) ||O(1)||
|  86  |Unique Morse Code Words|[LC](https://leetcode.com/problems/unique-morse-code-words/) |||O(1)||
|  87  |Valid Anagram|[LC](https://leetcode.com/problems/valid-anagram/) |[CPP](./Strings/LC_242_ValidAnagram.cpp) [Java](./Strings/AnagramCheck.java) ||O(n)||
|  88  |Valid Number|[LC](https://leetcode.com/problems/valid-number/) |[Java](./Strings/ValidNumber.java) ||O(n)||
|  89  |Valid Palindrome|[LC](https://leetcode.com/problems/valid-palindrome/) |[Java](./Strings/CheckPalindrome.java) ||O(n)||
|  90  |Valid Palindrome Ii|[LC](https://leetcode.com/problems/valid-palindrome-ii/) |[Java](./Strings/CheckPalindrome2.java) ||O(n)||
|  91  |Validate An Ip Address 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1) |[Java](./Strings/ValidateIPAddress.java) |Medium|O(n)||
|  92  |Validate Ip Address|[LC](https://leetcode.com/problems/validate-ip-address/) |[Java](./Strings/ValidateIPAddressLeetcode.java) ||O(n)||
|  93  |Verifying An Alien Dictionary|[LC](https://leetcode.com/problems/verifying-an-alien-dictionary/) |[Java](./Strings/VerifyAlienDictionary.java) ||O(n<sup>2</sup>)||
## Tree

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Binary Tree To Linked List|[BS](https://binarysearch.com/problems/Binary-Tree-to-Linked-List) |[Java](./Tree/BinaryTreeToLinkedList.java) ||O(1)||
|  2  |Count Nodes In Complete Binary Tree|[BS](https://binarysearch.com/problems/Count-Nodes-in-Complete-Binary-Tree) [LC](https://leetcode.com/problems/count-complete-tree-nodes/) |[Java](./Tree/CountNodesInCompleteBinaryTree.java) ||O(n)||
|  3  |Delete Even Leaves|[BS](https://binarysearch.com/problems/Delete-Even-Leaves) |[Java](./Tree/DeleteEvenLeaves.java) ||O(1)||
|  4  |Elephant Tree|[BS](https://binarysearch.com/problems/Elephant-Tree) [GFG](https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1) |[Java](./Tree/ConvertIntoSumTree.java) |Easy|O(1)||
|  5  |Height Balanced Tree|[BS](https://binarysearch.com/problems/Height-Balanced-Tree) |[Java](./Tree/HeightBalancedTree.java) ||O(1)||
|  6  |Inorder Successor|[BS](https://binarysearch.com/problems/Inorder-Successor) |[Java](./Tree/InorderSuccessor.java) ||O(n)||
|  7  |Largest Tree Sum Path|[BS](https://binarysearch.com/problems/Largest-Tree-Sum-Path) |[Java](./Tree/LargestTreeSumPath.java) ||O(n)||
|  8  |Leaves In Same Level|[BS](https://binarysearch.com/problems/Leaves-in-Same-Level) [GFG](https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1) |[Java](./Tree/LeafAtSameLevel.java) |Easy|O(1)||
|  9  |Longest Tree Sum Path From Root To Leaf|[BS](https://binarysearch.com/problems/Longest-Tree-Sum-Path-From-Root-to-Leaf) |[Java](./Tree/LongestTreeSumPathFromRootToLeaf.java) ||O(1)||
|  10  |Lowest Common Ancestor|[BS](https://binarysearch.com/problems/Lowest-Common-Ancestor) [GFG](https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1) [GFG](https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1) |[Java](./Tree/FindLowestCommonAncestor.java) |Medium|O(n)||
|  11  |Merging Binary Trees|[BS](https://binarysearch.com/problems/Merging-Binary-Trees) |[Java](./Tree/MergingBinaryTrees.java) ||O(1)||
|  12  |Most Frequent Subtree Sum|[BS](https://binarysearch.com/problems/Most-Frequent-Subtree-Sum) |[Java](./Tree/MostFrequentSubtreeSum.java) ||O(n)||
|  13  |Partition Tree|[BS](https://binarysearch.com/problems/Partition-Tree) |[Java](./Tree/PartitionTree.java) ||O(n<sup>2</sup>)||
|  14  |Subtree With Maximum Value|[BS](https://binarysearch.com/problems/Subtree-with-Maximum-Value) |[Java](./Tree/SubtreeWithMaximumValue.java) ||O(1)||
|  15  |Sum Tree|[BS](https://binarysearch.com/problems/Sum-Tree) |[Java](./Tree/CheckIfSumTree.java) ||O(1)||
|  16  |Symmetric Binary Tree|[BS](https://binarysearch.com/problems/Symmetric-Binary-Tree) [LC](https://leetcode.com/problems/symmetric-tree/) |[Java](./Tree/CheckMirror.java) ||O(1)||
|  17  |Tree Pruning|[BS](https://binarysearch.com/problems/Tree-Pruning) |[Java](./Tree/TreePruning.java) ||O(1)||
|  18  |Univalue Tree|[BS](https://binarysearch.com/problems/Univalue-Tree) |[Java](./Tree/UniValueTree.java) ||O(1)||
|  19  |Add All Greater Values To Every Node In A Bst|[GFG](https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1) |[Java](./Tree/GreaterValueAddition.java) |Medium|O(1)||
|  20  |Add One Row To Tree|[LC](https://leetcode.com/problems/add-one-row-to-tree/) |[Java](./Tree/AddOneRowToTree.java) ||O(1)||
|  21  |All Elements In Two Binary Search Trees|[LC](https://leetcode.com/problems/all-elements-in-two-binary-search-trees/) |[Java](./Tree/AllElementsInTwoBinarySearchTrees.java) ||O(1)||
|  22  |All Nodes Distance K In Binary Tree|[LC](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/) |[Java](./Tree/AllNodesDistanceKInBinaryTree.java) ||O(n<sup>3</sup>)||
|  23  |Balanced Binary Tree|[LC](https://leetcode.com/problems/balanced-binary-tree/) |[Java](./Tree/CheckIfBalanced.java) ||O(1)||
|  24  |Binary Search Tree Iterator|[LC](https://leetcode.com/problems/binary-search-tree-iterator/) |[Java](./Tree/BinarySearchTreeIterator.java) ||O(n)||
|  25  |Binary Search Tree To Greater Sum Tree|[LC](https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/) |[Java](./Tree/BinarySearchTreeToGreaterSumTree.java) ||O(1)||
|  26  |Binary Tree Cameras|[LC](https://leetcode.com/problems/binary-tree-cameras/) |[Java](./Tree/BinaryTreeCameras.java) ||O(1)||
|  27  |Binary Tree K Level Sum3857|[GFG](https://practice.geeksforgeeks.org/problems/binary-tree-k-level-sum3857/1) |[Java](./Tree/KLevelSum.java) |Easy|O(n<sup>2</sup>)||
|  28  |Binary Tree Level Order Traversal|[LC](https://leetcode.com/problems/binary-tree-level-order-traversal/) |[CPP](./Tree/LC_102_BinaryTreeLevelOrderTraversal.cpp) [Java](./Tree/LevelOrderTraversal.java) ||O(1)||
|  29  |Binary Tree Maximum Path Sum|[LC](https://leetcode.com/problems/binary-tree-maximum-path-sum/) [GFG](https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1) |[Java](./Tree/MaximumPathSumFromAnyNode.java) |Medium|O(1)||
|  30  |Binary Tree Paths|[LC](https://leetcode.com/problems/binary-tree-paths/) |[Java](./Tree/BinaryTreePaths.java) ||O(1)||
|  31  |Binary Tree Tilt|[LC](https://leetcode.com/problems/binary-tree-tilt/) |[Java](./Tree/BinaryTreeTilt.java) ||O(1)||
|  32  |Binary Tree To Bst|[GFG](https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1) |[Java](./Tree/BinaryTreeToBST.java) |Easy|O(1)||
|  33  |Binary Tree To Dll|[GFG](https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1) |[Java](./Tree/BinaryTreeToDLL.java) |Hard|O(1)||
|  34  |Binary Tree Zigzag Level Order Traversal|[LC](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) |[Java](./Tree/ZigzagLevelOrderTraversal.java) ||O(n<sup>2</sup>)||
|  35  |Bottom View Of Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1) |[Java](./Tree/BottomView.java) |Medium|O(n)||
|  36  |Boundary Traversal Of Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1) |[CPP](./Tree/GFG_BoundaryTraversal.cpp) [Java](./Tree/BoundaryTraversal.java) |Medium|O(1)||
|  37  |Brothers From Different Root|[GFG](https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1#) |[Java](./Tree/BrothersFromDifferentRoots.java) |Easy|O(n)||
|  38  |Bst To Greater Sum Tree|[GFG](https://practice.geeksforgeeks.org/problems/bst-to-greater-sum-tree/1) |[Java](./Tree/BstToGreaterSumTree.java) |Medium|O(1)||
|  39  |Burning Tree|[GFG](https://practice.geeksforgeeks.org/problems/burning-tree/1) |[Java](./Tree/BurnTree.java) |Hard|O(n<sup>3</sup>)||
|  40  |Check Completeness Of A Binary Tree|[LC](https://leetcode.com/problems/check-completeness-of-a-binary-tree/) |[Java](./Tree/CheckCompletenessOfABinaryTree.java) ||O(n)||
|  41  |Check For Balanced Tree|[GFG](https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1) |[CPP](./Tree/GFG_Tree_BalancedTree.cpp) |Easy|O(1)||
|  42  |Check If Subtree|[GFG](https://practice.geeksforgeeks.org/problems/check-if-subtree/1) |[Java](./Tree/CheckIfSubtree.java) |Medium|O(n)||
|  43  |Check If Tree Is Isomorphic|[GFG](https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1) |[Java](./Tree/CheckIfTreeIsIsomorphic.java) |Easy|O(1)||
|  44  |Check Mirror In N Ary Tree1528|[GFG](https://practice.geeksforgeeks.org/problems/check-mirror-in-n-ary-tree1528/1) |[Java](./Tree/CheckMirrorInNAryTree.java) |Medium|O(n<sup>2</sup>)||
|  45  |Check Whether Bst Contains Dead End|[GFG](https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1) |[Java](./Tree/CheckDeadEnd.java) |Easy|O(1)||
|  46  |Children Sum Parent|[GFG](https://practice.geeksforgeeks.org/problems/children-sum-parent/1/#) |[CPP](./Tree/GFG_ChildrenSumParent.cpp) |Easy|O(1)||
|  47  |Complete Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/complete-binary-tree/1) |[Java](./Tree/CompleteBinaryTree.java) |Medium|O(n<sup>2</sup>)||
|  48  |Connect Nodes At Same Level|[GFG](https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1) |[Java](./Tree/ConnectNodesAtSameLevel.java) |Medium|O(n)||
|  49  |Construct Binary Search Tree From Preorder Traversal|[LC](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) [GFG](https://practice.geeksforgeeks.org/problems/construct-tree-1/1/) [LC](leetcode 1008, https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) |[Java](./Tree/BuildTreeFromInAndPre.java) |Medium|O(n)||
|  50  |Construct Binary Tree From Preorder And Postorder Traversal|[LC](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/) |[Java](./Tree/ConstructBinaryTreeFromPreorderAndPostorderTraversal.java) ||O(n)||
|  51  |Construct Binary Tree From String With Bracket Representation|[GFG](https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-string-with-bracket-representation/1/) |[Java](./Tree/ConstructBinaryTreeFromStringWithBracketRepresentation.java) |Medium|O(n)||
|  52  |Construct String From Binary Tree|[LC](https://leetcode.com/problems/construct-string-from-binary-tree/) |[Java](./Tree/BinaryTreeToString.java) ||O(1)||
|  53  |Convert Sorted Array To Binary Search Tree|[LC](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) |[CPP](./Tree/GFG_LC_108_SortedArrayToBST.cpp) [Java](./Tree/SortedArrayToBalancedBST.java) ||O(1)||
|  54  |Count Bst Nodes That Lie In A Given Range|[GFG](https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1/) |[CPP](./Tree/GFG_CountBSTnodesInRange.cpp) [Java](./Tree/CountNodesInRange.java) |Medium|O(1)||
|  55  |Count Good Nodes In Binary Tree|[LC](https://leetcode.com/problems/count-good-nodes-in-binary-tree/) |[Java](./Tree/CountGoodNodes.java) ||O(1)||
|  56  |Count Nodes Equal To Average Of Subtree|[LC](https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/) |[Java](./Tree/CountNodesEqualToAverageOfSubtree.java) ||O(1)||
|  57  |Count Number Of Subtrees Having Given Sum|[GFG](https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1) |[Java](./Tree/CountNumberOfSubtreesHavingGivenSum.java) |Medium|O(1)||
|  58  |Cousins In Binary Tree|[LC](https://leetcode.com/problems/cousins-in-binary-tree/) |[Java](./Tree/AreCousins.java) ||O(n<sup>2</sup>)||
|  59  |Cousins Of A Given Node|[GFG](https://practice.geeksforgeeks.org/problems/cousins-of-a-given-node/1) |[Java](./Tree/Cousins.java) |Medium|O(n<sup>2</sup>)||
|  60  |Create Binary Tree From Descriptions|[LC](https://leetcode.com/problems/create-binary-tree-from-descriptions/) |[Java](./Tree/CreateBinaryTreeFromDescriptions.java) ||O(n)||
|  61  |Deepest Leaves Sum|[LC](https://leetcode.com/problems/deepest-leaves-sum/) |[Java](./Tree/DeepestLeavesSum.java) ||O(1)||
|  62  |Delete Leaves With A Given Value|[LC](https://leetcode.com/problems/delete-leaves-with-a-given-value/) |[Java](./Tree/DeleteLeavesWithGivenValue.java) ||O(1)||
|  63  |Delete Node In A Bst|[LC](https://leetcode.com/problems/delete-node-in-a-bst/) |[CPP](./Tree/LC_450_DeleteFromBST.cpp) [Java](./Tree/DeleteFromBST.java) ||O(n)||
|  64  |Delete Nodes And Return Forest|[LC](https://leetcode.com/problems/delete-nodes-and-return-forest/) |[Java](./Tree/DeleteNodesAndReturnForest.java) ||O(n)||
|  65  |Determine If Two Trees Are Identical|[GFG](https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1) |[CPP](./Tree/GFG_DetermineIfTwoTreesIdentical.cpp) [Java](./Tree/CheckIfIdentical.java) |Easy|O(1)||
|  66  |Diagonal Traversal Of Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1) |[Java](./Tree/DiagonalTraversal.java) |Medium|O(n<sup>2</sup>)||
|  67  |Diameter Of Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1) |[Java](./Tree/Diameter.java) |Easy|O(1)||
|  68  |Distribute Coins In Binary Tree|[LC](https://leetcode.com/problems/distribute-coins-in-binary-tree/) [GFG](https://practice.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1) |[Java](./Tree/DistributeCoinsCandiesInBinaryTree.java) |null|O(1)||
|  69  |Duplicate Subtree In Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1/) |[Java](./Tree/CheckForDuplicateSubtrees.java) |Medium|O(n<sup>4</sup>)||
|  70  |Evaluate Boolean Binary Tree|[LC](https://leetcode.com/problems/evaluate-boolean-binary-tree/) |[Java](./Tree/EvaluateBooleanBinaryTree.java) ||O(1)||
|  71  |Even Odd Tree|[LC](https://leetcode.com/problems/even-odd-tree/) |[Java](./Tree/EvenOddTree.java) ||O(n)||
|  72  |Expression Tree|[GFG](https://practice.geeksforgeeks.org/problems/expression-tree/1) |[Java](./Tree/ExpressionTree.java) |Easy|O(1)||
|  73  |Ffd66b6a0bf7cefb9987fa455974b6ea5695709e|[GFG](https://practice.geeksforgeeks.org/problems/ffd66b6a0bf7cefb9987fa455974b6ea5695709e/1) |[Java](./Tree/BinarySearch.java) |Easy|O(n<sup>2</sup>)||
|  74  |Find A Corresponding Node Of A Binary Tree In A Clone Of That Tree|[LC](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/) |[Java](./Tree/FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree.java) ||O(1)||
|  75  |Find A Pair With Given Target In Bst|[GFG](https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1) |[CPP](./Tree/GFG_FindPairWithSumBST.cpp) [Java](./Tree/FindPairInBST.java) |Medium|O(n)||
|  76  |Find Duplicate Subtrees|[LC](https://leetcode.com/problems/find-duplicate-subtrees/) |[Java](./Tree/FindDuplicateSubTrees.java) ||O(n)||
|  77  |Find Largest Value In Each Tree Row|[LC](https://leetcode.com/problems/find-largest-value-in-each-tree-row/) |[Java](./Tree/FindLargestValueInEachTreeRow.java) ||O(n<sup>2</sup>)||
|  78  |Find Mode In Binary Search Tree|[LC](https://leetcode.com/problems/find-mode-in-binary-search-tree/) |[Java](./Tree/FindMode.java) ||O(n)||
|  79  |Find The Closest Element In Bst|[GFG](https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1) |[Java](./Tree/ClosestElementInBST.java) |Medium|O(n)||
|  80  |Find The Distance Between Two Nodes4402|[GFG](https://practice.geeksforgeeks.org/problems/find-the-distance-between-two-nodes4402/1) |[Java](./Tree/ShortestDistance.java) |Easy|O(n)||
|  81  |Flatten Binary Tree To Linked List|[LC](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) |[Java](./Tree/BinaryTreeToSLL.java) ||O(n<sup>2</sup>)||
|  82  |Flip Binary Tree To Match Preorder Traversal|[LC](https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/) |[Java](./Tree/FlipBinaryTreeToMatchPreorderTraversal.java) ||O(1)||
|  83  |Foldable Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/foldable-binary-tree/1) |[Java](./Tree/FoldableBinaryTree.java) |Medium|O(1)||
|  84  |Increasing Order Search Tree|[LC](https://leetcode.com/problems/increasing-order-search-tree/) |[Java](./Tree/IncreasingOrderSearchTree.java) ||O(1)||
|  85  |Inorder Successor In Bst|[GFG](https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1) |[CPP](./Tree/GFG_inOrderSuccBST.cpp) [Java](./Tree/FindInorderSuccessor.java) |Easy|O(1)||
|  86  |Inorder Traversal Iterative|[GFG](https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative/0/) |[Java](./Tree/IterativeInOrder.java) |Medium|O(n)||
|  87  |Insert Into A Binary Search Tree|[LC](https://leetcode.com/problems/insert-into-a-binary-search-tree/) |[CPP](./Tree/LC_701_InsertIntoBST.cpp) [Java](./Tree/InsertIntoBST.java) ||O(1)||
|  88  |Insufficient Nodes In Root To Leaf Paths|[LC](https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/) |[Java](./Tree/InsufficientNodesInRootToLeafPaths.java) ||O(1)||
|  89  |Invert Binary Tree|[LC](https://leetcode.com/problems/invert-binary-tree/) |[CPP](./Tree/LC_226_Tree_InvertBinaryTree.cpp) ||O(1)||
|  90  |Kth Smallest Element In A Bst|[LC](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) [GFG](https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1) |[Java](./Tree/KthSmallestElement.java) |Easy|O(1)||
|  91  |Largest Bst|[GFG](https://practice.geeksforgeeks.org/problems/largest-bst/1) |[Java](./Tree/LargestBST.java) |Medium|O(1)||
|  92  |Largest Subtree Sum In A Tree|[GFG](https://practice.geeksforgeeks.org/problems/largest-subtree-sum-in-a-tree/1/) |[Java](./Tree/LargestSubtreeSumInATree.java) |Hard|O(1)||
|  93  |Largest Value In Each Level|[GFG](https://practice.geeksforgeeks.org/problems/largest-value-in-each-level/1) |[Java](./Tree/LargestValueInEachLevel.java) |Easy|O(n<sup>2</sup>)||
|  94  |Leaf At Same Level|[GFG](https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1) |[CPP](./Tree/GFG_Tree_LeafAtSameLevel.cpp) |Easy|O(1)||
|  95  |Leaf Similar Trees|[LC](https://leetcode.com/problems/leaf-similar-trees/) |[Java](./Tree/LeafSimilarTrees.java) ||O(n<sup>2</sup>)||
|  96  |Left View Of Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1#) |[CPP](./Tree/GFG_Tree_LeftView.cpp) [Java](./Tree/LeftView.java) |Easy|O(1)||
|  97  |Longest Path With Different Adjacent Characters|[LC](https://leetcode.com/problems/longest-path-with-different-adjacent-characters/) |[Java](./Tree/LongestPathWithDifferentAdjacentCharacters.java) ||O(n)||
|  98  |Longest Univalue Path|[LC](https://leetcode.com/problems/longest-univalue-path/) |[Java](./Tree/LongestUnivaluePath.java) ||O(1)||
|  99  |Lowest Common Ancestor Of Deepest Leaves|[LC](https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/) |[Java](./Tree/LowestCommonAncestorOfDeepestLeaves.java) ||O(1)||
|  100  |Maximum Depth Of Binary Tree|[LC](https://leetcode.com/problems/maximum-depth-of-binary-tree/) |[CPP](./Tree/LC_104_MaxDepthBinaryTree.cpp) [Java](./Tree/Height.java) ||O(1)||
|  101  |Maximum Difference Between Node And Ancestor|[LC](https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/) |[Java](./Tree/MaximumDifferenceBetweenAncestorAndNode.java) ||O(n)||
|  102  |Maximum Difference Between Node And Its Ancestor|[GFG](https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1) |[Java](./Tree/MaximumDifferenceAncestorNode.java) |Medium|O(n)||
|  103  |Maximum Level Sum Of A Binary Tree|[LC](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/) |[Java](./Tree/MaxLevelSum.java) ||O(n<sup>2</sup>)||
|  104  |Maximum Path Sum|[GFG](https://practice.geeksforgeeks.org/problems/maximum-path-sum/1) |[Java](./Tree/MaximumPathSumBetweenTwoLeaves.java) |Hard|O(1)||
|  105  |Maximum Sum Leaf To Root Path|[GFG](https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1) |[Java](./Tree/MaxSumPath.java) |Medium|O(1)||
|  106  |Maximum Width Of Binary Tree|[LC](https://leetcode.com/problems/maximum-width-of-binary-tree/) |[Java](./Tree/MaximumWidthOfBinaryTree.java) ||O(n<sup>2</sup>)||
|  107  |Maximum Width Of Tree|[GFG](https://practice.geeksforgeeks.org/problems/maximum-width-of-tree/1) |[Java](./Tree/MaximumWidthOfTree.java) |Easy|O(n<sup>2</sup>)||
|  108  |Merge Bsts To Create Single Bst|[LC](https://leetcode.com/problems/merge-bsts-to-create-single-bst/) |[Java](./Tree/MergeBSTsToCreateSingleBST.java) ||O(1)||
|  109  |Merge Two Binary Trees|[LC](https://leetcode.com/problems/merge-two-binary-trees/) |[CPP](./Tree/LC_617_MergeTwoBST.cpp) [Java](./Tree/MergeTwoBinaryTrees.java) ||O(1)||
|  110  |Merge Two Bst S|[GFG](https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1) |[Java](./Tree/MergeTwoBSTs.java) |Hard|O(n)||
|  111  |Min Distance Between Two Given Nodes Of A Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1/) |[Java](./Tree/FindDistance.java) |Medium|O(1)||
|  112  |Minimum Height Trees|[LC](https://leetcode.com/problems/minimum-height-trees/) |[Java](./Tree/MinimumHeightTrees.java) ||O(n<sup>2</sup>)||
|  113  |Minimum Swap Required To Convert Binary Tree To Binary Search Tree|[GFG](https://practice.geeksforgeeks.org/problems/minimum-swap-required-to-convert-binary-tree-to-binary-search-tree/1/) |[Java](./Tree/MinimumSwapsRequiredToConvertBinaryTreeToBinarySearchTree.java) |Hard|O(n<sup>2</sup>)||
|  114  |Mirror Tree|[GFG](https://practice.geeksforgeeks.org/problems/mirror-tree/1) |[Java](./Tree/Mirror.java) |Easy|O(1)||
|  115  |N Ary Tree Level Order Traversal|[LC](https://leetcode.com/problems/n-ary-tree-level-order-traversal/) |[Java](./Tree/NAryLevelOrderTraversal.java) ||O(n<sup>3</sup>)||
|  116  |N Ary Tree Postorder Traversal|[LC](https://leetcode.com/problems/n-ary-tree-postorder-traversal/) |[Java](./Tree/NAryPostOrder.java) ||O(n)||
|  117  |N Ary Tree Preorder Traversal|[LC](https://leetcode.com/problems/n-ary-tree-preorder-traversal/) |[Java](./Tree/NAryPreOrder.java) ||O(n)||
|  118  |Next Right Node|[GFG](https://practice.geeksforgeeks.org/problems/next-right-node/1) |[CPP](./Tree/NextRightNode.cpp) |Easy|O(1)||
|  119  |Node At Distance|[GFG](https://practice.geeksforgeeks.org/problems/node-at-distance/1) |[Java](./Tree/NodeAtDistance.java) |Medium|O(1)||
|  120  |Nodes At Given Distance In Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1) |[Java](./Tree/FindNodesAtDistanceK.java) |Hard|O(n)||
|  121  |Number Of Good Leaf Nodes Pairs|[LC](https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/) |[Java](./Tree/NumberOfGoodLeafNodePairs.java) ||O(n<sup>2</sup>)||
|  122  |Number Of Nodes In The Sub Tree With The Same Label|[LC](https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/) |[Java](./Tree/NumberOfNodesInTheSubtreeWithTheSameLabel.java) ||O(n<sup>2</sup>)||
|  123  |Number Of Turns In Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/number-of-turns-in-binary-tree/1) |[Java](./Tree/NumberOfTurnsInBinaryTree.java) |Hard|O(1)||
|  124  |Odd Even Level Difference|[GFG](https://practice.geeksforgeeks.org/problems/odd-even-level-difference/1) |[Java](./Tree/OddEvenLevelDifference.java) |Easy|O(n<sup>2</sup>)||
|  125  |Pairs Violating Bst Property|[GFG](https://practice.geeksforgeeks.org/problems/pairs-violating-bst-property/1) |[Java](./Tree/PairsViolatingBSTProperty.java) |Medium|O(n)||
|  126  |Path In Zigzag Labelled Binary Tree|[LC](https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/) |[Java](./Tree/PathInZigzagLabelledBinaryTree.java) ||O(n)||
|  127  |Path Sum|[LC](https://leetcode.com/problems/path-sum/) |[CPP](./Tree/LC_112_PathSum.cpp) [Java](./Tree/IsPathSumPresent.java) ||O(1)||
|  128  |Path Sum Ii|[LC](https://leetcode.com/problems/path-sum-ii/) |[Java](./Tree/FindAllPathsWithGivenSum.java) ||O(n)||
|  129  |Path Sum Iii|[LC](https://leetcode.com/problems/path-sum-iii/) [GFG](https://practice.geeksforgeeks.org/problems/k-sum-paths/1/) |[Java](./Tree/PathSum3.java) |Medium|O(1)||
|  130  |Paths From Root With A Specified Sum|[GFG](https://practice.geeksforgeeks.org/problems/paths-from-root-with-a-specified-sum/1) |[Java](./Tree/PathsFromRootWithASpecifiedSum.java) |Medium|O(n)||
|  131  |Populate Inorder Successor For All Nodes|[GFG](https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1#) |[CPP](./Tree/GFG_PopulateInorderSuccForAllNodes.cpp) [Java](./Tree/PopulateInorderSuccessors.java) |Medium|O(1)||
|  132  |Populating Next Right Pointers In Each Node|[LC](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) |[Java](./Tree/PopulateRightPointers.java) ||O(n<sup>2</sup>)||
|  133  |Postorder Traversal Iterative|[GFG](https://practice.geeksforgeeks.org/problems/postorder-traversal-iterative/0/) |[Java](./Tree/IterativePostOrder.java) |Medium|O(n)||
|  134  |Predecessor And Successor|[GFG](https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1/) |[Java](./Tree/SuccAndPre.java) |Easy|O(1)||
|  135  |Preorder Traversal And Bst4006|[GFG](https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1/) |[Java](./Tree/CheckIfPreorderOfBST.java) |Medium|O(n)||
|  136  |Preorder Traversal Iterative|[GFG](https://practice.geeksforgeeks.org/problems/preorder-traversal-iterative/0/) |[Java](./Tree/IterativePreOrder.java) |Medium|O(n)||
|  137  |Print Binary Tree|[LC](https://leetcode.com/problems/print-binary-tree/) |[Java](./Tree/PrintBinaryTree.java) ||O(n<sup>2</sup>)||
|  138  |Print Nodes Having K Leaves|[GFG](https://practice.geeksforgeeks.org/problems/print-nodes-having-k-leaves/1) |[Java](./Tree/PrintNodesHavingKLeaves.java) |Medium|O(1)||
|  139  |Pseudo Palindromic Paths In A Binary Tree|[LC](https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/) |[Java](./Tree/PseudoPalindromicPathsInABinaryTree.java) ||O(n)||
|  140  |Recover A Tree From Preorder Traversal|[LC](https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/) |[Java](./Tree/RecoverATreeFromPreorderTraversal.java) ||O(n<sup>2</sup>)||
|  141  |Recover Binary Search Tree|[LC](https://leetcode.com/problems/recover-binary-search-tree/) [GFG](https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1) |[Java](./Tree/RecoverBinarySearchTree.java) |null|O(1)||
|  142  |Remove Bst Keys Outside Given Range|[GFG](https://practice.geeksforgeeks.org/problems/remove-bst-keys-outside-given-range/1/) |[Java](./Tree/RemoveNodesOutsideRange.java) |Medium|O(n<sup>2</sup>)||
|  143  |Reverse Level Order Traversal|[GFG](https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1#) |[CPP](./Tree/GFG_Tree_ReverseOrderTraversal.cpp) [Java](./Tree/ReverseLevelOrder.java) |Easy|O(1)||
|  144  |Right View Of Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1) |[CPP](./Tree/GFG_Tree_RightView.cpp) [Java](./Tree/RightView.java) |Easy|O(1)||
|  145  |Second Minimum Node In A Binary Tree|[LC](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/) |[Java](./Tree/SecondMinimumNodeInABinarySearchTree.java) ||O(1)||
|  146  |Serialize And Deserialize Binary Tree|[LC](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) [GFG](https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1) |[Java](./Tree/SerializeAndDeserialize.java) |Medium|O(1)||
|  147  |Single Valued Subtree|[GFG](https://practice.geeksforgeeks.org/problems/single-valued-subtree/1) |[Java](./Tree/SingleValuedSubtree.java) |Medium|O(1)||
|  148  |Smallest String Starting From Leaf|[LC](https://leetcode.com/problems/smallest-string-starting-from-leaf/) |[Java](./Tree/SmallestStringStartingFromLeaf.java) ||O(1)||
|  149  |Smallest Subtree With All The Deepest Nodes|[LC](https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/) |[Java](./Tree/SmallestSubtreeWithAllTheDeepestNodes.java) ||O(n)||
|  150  |Subtree Of Another Tree|[LC](https://leetcode.com/problems/subtree-of-another-tree/) |[Java](./Tree/SubtreeOfAnotherTree.java) ||O(1)||
|  151  |Sum Of Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/sum-of-binary-tree/1/) |[Java](./Tree/TreeSum.java) |Basic|O(1)||
|  152  |Sum Of K Smallest Elements In Bst3029|[GFG](https://practice.geeksforgeeks.org/problems/sum-of-k-smallest-elements-in-bst3029/1) |[Java](./Tree/SumOfKSmallestElements.java) |Easy|O(n)||
|  153  |Sum Of Nodes With Even Valued Grandparent|[LC](https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/) |[Java](./Tree/SumOfNodesWithEvenValuedGrandParent.java) ||O(1)||
|  154  |Sum Of Root To Leaf Binary Numbers|[LC](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/) |[Java](./Tree/SumOfRootToLeafBinaryNumbers.java) ||O(1)||
|  155  |Sum Of The Longest Bloodline Of A Tree|[GFG](https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1#) |[CPP](./Tree/GFG_Tree_SumLongestBloodlineOfaTree.cpp) [Java](./Tree/SumOfLongestBloodLine.java) |Easy|O(1)||
|  156  |Sum Root To Leaf Numbers|[LC](https://leetcode.com/problems/sum-root-to-leaf-numbers/) |[Java](./Tree/SumRootToLeafNumbers.java) ||O(1)||
|  157  |Sum Tree|[GFG](https://practice.geeksforgeeks.org/problems/sum-tree/1) |[Java](./Tree/CheckSumTree.java) |Medium|O(1)||
|  158  |Symmetric Tree|[GFG](https://practice.geeksforgeeks.org/problems/symmetric-tree/1) |[CPP](./Tree/LC_101_Tree_Symmetric.cpp) [Java](./Tree/CheckIfSymmetric.java) |Easy|O(1)||
|  159  |Top View Of Binary Tree|[GFG](https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1) |[Java](./Tree/TopView.java) |Medium|O(n)||
|  160  |Tree From Postorder And Inorder|[GFG](https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1/) |[Java](./Tree/BuildTreeFromInAndPost.java) |Medium|O(n)||
|  161  |Trim A Binary Search Tree|[LC](https://leetcode.com/problems/trim-a-binary-search-tree/) |[CPP](./Tree/LC_669_TrimBST.cpp) [Java](./Tree/TrimABinarySearchTree.java) ||O(1)||
|  162  |Two Mirror Trees|[GFG](https://practice.geeksforgeeks.org/problems/two-mirror-trees/1) |[Java](./Tree/TwoMirrorTrees.java) |Easy|O(1)||
|  163  |Unique Binary Search Trees Ii|[LC](https://leetcode.com/problems/unique-binary-search-trees-ii/) |[Java](./Tree/UniqueBinarySearchTrees.java) ||O(n)||
|  164  |Unique Bsts 1587115621|[GFG](https://practice.geeksforgeeks.org/problems/unique-bsts-1587115621/1#) |[Java](./Tree/UniqueBSTs.java) |Medium|O(n<sup>2</sup>)||
|  165  |Validate Binary Search Tree|[LC](https://leetcode.com/problems/validate-binary-search-tree/) |[CPP](./Tree/LC_98_ValidateBST.cpp) [Java](./Tree/IsBST.java) ||O(1)||
|  166  |Validate Binary Tree Nodes|[LC](https://leetcode.com/problems/validate-binary-tree-nodes/) |[Java](./Tree/ValidateBinaryTreeNodes.java) ||O(n)||
|  167  |Verify Preorder Serialization Of A Binary Tree|[LC](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/) |[Java](./Tree/VerifyPreorderSerializationOfATree.java) ||O(1)||
|  168  |Vertical Order Traversal Of A Binary Tree|[LC](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/) [GFG](https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1) |[Java](./Tree/VerticalTraversal.java) |Medium|O(n<sup>2</sup>)||
## Trie

|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |
|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |
|  1  |Distinct Substrings|[BS](https://binarysearch.com/problems/Distinct-Substrings) [GFG](https://practice.geeksforgeeks.org/problems/count-of-distinct-substrings/1) |[Java](./Trie/DistinctSubstrings.java) |Medium|O(n)||
|  2  |Implement Trie Prefix Tree|[LC](https://leetcode.com/problems/implement-trie-prefix-tree/) |[Java](./Trie/TriePrefixTree.java) ||O(n)||
|  3  |Maximum Xor Of Two Numbers In An Array|[LC](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/) |[Java](./Trie/MaximumXorPair.java) ||O(n)||
|  4  |Minimum Xor Value Pair|[GFG](https://practice.geeksforgeeks.org/problems/minimum-xor-value-pair/1/) |[Java](./Trie/MinimumXorPair.java) |Medium|O(n)||
|  5  |Palindrome Pairs|[GFG](https://practice.geeksforgeeks.org/problems/palindrome-pairs/1) |[Java](./Trie/PalindromePairs.java) |Hard|O(n)||
|  6  |Phone Directory4628|[GFG](https://practice.geeksforgeeks.org/problems/phone-directory4628/1) |[Java](./Trie/PhoneDirectory.java) |Hard|O(n)||
|  7  |Search Suggestions System|[LC](https://leetcode.com/problems/search-suggestions-system/) |[Java](./Trie/SearchSuggestionSystem.java) ||O(n<sup>2</sup>)||
|  8  |Short Encoding Of Words|[LC](https://leetcode.com/problems/short-encoding-of-words/) |[Java](./Trie/ShortestEncoding.java) ||O(n<sup>2</sup>)||
|  9  |Shortest Unique Prefix For Every Word|[GFG](https://practice.geeksforgeeks.org/problems/shortest-unique-prefix-for-every-word/0/) |[Java](./Trie/ShortestUniquePrefixForEveryWord.java) |Hard|O(n)||
|  10  |Stream Of Characters|[LC](https://leetcode.com/problems/stream-of-characters/) |[Java](./Trie/StreamOfCharacters.java) ||O(n)||
|  11  |Trie Delete|[GFG](https://practice.geeksforgeeks.org/problems/trie-delete/1#) |[CPP](./Trie/GFG_TrieDelete.cpp) [Java](./Trie/TrieDelete.java) |Medium|O(1)||
|  12  |Trie Insert And Search0651|[GFG](https://practice.geeksforgeeks.org/problems/trie-insert-and-search0651/1#) |[CPP](./Trie/GFG_TrieInsertSearch.cpp) [Java](./Trie/Trie.java) |Medium|O(1)||
|  13  |Unique Rows In Boolean Matrix|[GFG](https://practice.geeksforgeeks.org/problems/unique-rows-in-boolean-matrix/1) |[Java](./Trie/UniqueRowsInMatrix.java) |Easy|O(n)||
