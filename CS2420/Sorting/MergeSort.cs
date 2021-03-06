﻿using PEXP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sorting.Sorting
{
    class MergeSort : Algorithm
    {
        /// <summary>
        /// Sorts recursively using merge sort
        /// </summary>
        /// <param name="unsorted">The unsorted array</param>
        /// <returns></returns>
        public override IList<IComparable> Sort(IList<IComparable> unsorted)
        {
            if (unsorted.Count <= 1)
                return unsorted;
            //Split the array and then recursivley Sort untill single elements achieved
            var split = unsorted.Split();


            //Then return a Merge of the split elements.
            return this.Merge(Sort(split[0]), Sort(split[1]));
        }


        private IList<IComparable> Merge(IList<IComparable> left, IList<IComparable> right)
        {

            if(right.Count == 0)
                return left;
            else if (left.Count == 0)
                return right;

            IList<IComparable> result = new List<IComparable>();
            //cases

            while(left.Count + right.Count != 0){
                if(left.Count ==0)
                {
                    result.Add(right[0]);
                    right.RemoveAt(0);
                    continue;
                }
                if(right.Count == 0)
                {
                    result.Add(left[0]);
                    left.RemoveAt(0);
                    continue;
                }
                //Normal case

                if(left[0].CompareTo(right[0]) > 0)
                {
                    result.Add(right[0]);
                    right.RemoveAt(0);
                    continue;
                }
                else
                {
                    result.Add(left[0]);
                    left.RemoveAt(0);
                    continue;
                }

            }

            return result;


        }

        public override void Overhead(int n)
        {
            //rthrow new NotImplementedException();
        }
    }
}
