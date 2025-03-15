import { removeOrderItem } from "./removeOrderItem.js"
import { truncateOrderTable } from "./truncateOrderTable.js"

const truncateOrderTableBtn = document.getElementById("truncate-order-table-btn")

export function renderOrderList(orderList) {
    const foodContainer = document.getElementById('food-order')

    foodContainer.innerHTML = ''

    orderList.forEach(order => {
        const orderItem = document.createElement('div')
        orderItem.classList.add('food-item') 
        orderItem.innerHTML = `
            <h2>${order.name}</h2>
            <p><strong>Price:</strong> $${order.price.toFixed(2)}</p>
            <button class="remove-order-item" data-id="${order.customerOrderId}">Remove</button>
        `;

        foodContainer.appendChild(orderItem)
    });

    if (orderList.length === 0) {
        foodContainer.innerHTML = '<p>No items in the order found!</p>'
    }

    const removeBtns = document.querySelectorAll(".remove-order-item")

    removeBtns.forEach(button => {
        button.addEventListener("click", (e) => {
            const foodId = e.target.dataset.id
            removeOrderItem(foodId)
        })
    })

    truncateOrderTableBtn.addEventListener("click", () => {
        truncateOrderTable()
    })
}
