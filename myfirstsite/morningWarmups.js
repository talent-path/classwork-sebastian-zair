let nums1 = [4,9,5];
let nums2 = [9, 4,9,8,4];

let arr = [];
count = 0;

for(let i = 0; i < nums1.length; i++){
    for(let j = 0; j < nums2.length; j++){
        if(nums2[j] == nums1[i]){
            count++;
            arr.push(j);
        }
    }
}

let uniqueArr = [...Set(arr)];

return uniqueArr;