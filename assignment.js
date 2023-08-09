function cubeNumber(number) {
    if (typeof number !== "number") {
        return "Invalid input";
    }
    return number * number * number;
}


function matchFinder(string1, string2) {
    if (typeof string1 !== "string" || typeof string2 !== "string") {
        return "Invalid input";
    }
    if (string1.includes(string2)) {
        return true;
    }
    return false;
}

function sortMaker(arr) {
    if (arr[0] < 0 || arr[1] < 0) {
        return "Invalid Input"
    }
    if (arr[0] == arr[1]) {
        return "equal";
    }
    if (arr[0] >= 0 && arr[1] >= 0 && arr[0] < arr[1]) {
        let tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }
    return arr;
}


function findAddress(obj) {
    let keys = ["street", "house", "society"];
    let address = "";
    for (let i = 0; i < keys.length; i++) {
        if (keys[i] in obj) {
            if (i == 2) {
                address += obj[keys[i]];
            } else {
                address += obj[keys[i]]  + ",";
            }
        } else {
            if (i == 2) {
                address += "__";
            } else {
                address += "__" + ",";
            }
        }
    }
    return address;
}


function canPay(changeArray, totalDue) {
    if (changeArray.length == 0) {
        return "You don't have any money!";
    }
    let totalSum = 0;
    for (let i = 0; i < changeArray.length; i++) {
        totalSum += changeArray[i];
    }
    if (totalSum < totalDue) return false;
    return true;
}


let output = canPay([], 10)
console.log(output)