let programmer = {
    id: 100,
    name: 'md a barik',
    isSingle: true,
    friends: ['noyon', 'monir', 'mahfuz'],
    house: [{name: 'barik villa', year: 2023}, {name: "barik's wife house"}],
    act: function() {
        console.log("invoked act method")
    },
    car: {
        brand: 'tesla',
        price: 500000,
        made: 2025
    }
}

const products = [
    {name: 'phone', price: 12000},
    {name: 'laptop', price: 32000},
]

const products1 = {
    '0': 15,
    '1': 56,
    '2': 87
}


function add(n1, n2) {
    console.log(n1, n2);
    console.log(arguments)
}

console.log(parseInt(12.12))

let obj = {

}

function compare(a, b) {
    if (a.toString() === b) {
    return true;
    } else {
    return false;
    }
   }
   const result = compare(25, 25);
   console.log("123" + 123);