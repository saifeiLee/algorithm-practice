#include <iostream>
#include <vector>
using namespace std;

void merge(int array[], int left, int right)
{
    int mid = (left + right) / 2;
    int leftSubArraySize = mid - left + 1;
    int rightSubArraySize = right - mid;
    vector<int> leftSubArray(leftSubArraySize);
    vector<int> rightSubArray(rightSubArraySize);
    for (int i = 0; i < leftSubArraySize; ++i)
    {
        leftSubArray[i] = array[left + i];
    }
    // for (auto i : leftSubArray)
    // {
    //     cout << i << " ";
    // }
    // cout << endl;
    for (int j = 0; j < rightSubArraySize; ++j)
    {
        rightSubArray[j] = array[mid + 1 + j];
    }
    int indexOfLeftSubArray = 0;
    int indexOfRightSubArray = 0;
    int indexOfMergedArray = left;
    while (indexOfLeftSubArray < leftSubArraySize && indexOfRightSubArray < rightSubArraySize)
    {
        if (leftSubArray[indexOfLeftSubArray] <= rightSubArray[indexOfRightSubArray])
        {
            array[indexOfMergedArray] = leftSubArray[indexOfLeftSubArray];
            ++indexOfLeftSubArray;
            ++indexOfMergedArray;
        }
        else
        {
            array[indexOfMergedArray] = rightSubArray[indexOfRightSubArray];
            ++indexOfRightSubArray;
            ++indexOfMergedArray;
        }
    }

    while (indexOfLeftSubArray < leftSubArraySize)
    {
        array[indexOfMergedArray] = leftSubArray[indexOfLeftSubArray];
        ++indexOfLeftSubArray;
        ++indexOfMergedArray;
    }
    while (indexOfRightSubArray < rightSubArraySize)
    {
        array[indexOfMergedArray] = rightSubArray[indexOfRightSubArray];
        ++indexOfRightSubArray;
        ++indexOfMergedArray;
    }
}

void mergeSort(int array[], const int begin, const int end)
{
    if (begin < end)
    {
        int mid = (begin + end) / 2;
        mergeSort(array, begin, mid);
        mergeSort(array, mid + 1, end);
        merge(array, begin, end);
    }
    else
    {
        return;
    }
}

int main()
{
    int array[] = {5, 4, 3, 1, 10, 9, 8, 7, 6, 2};
    mergeSort(array, 0, 9);
    for (int i = 0; i < 10; ++i)
    {
        cout << array[i] << " ";
    }
    return 0;
}