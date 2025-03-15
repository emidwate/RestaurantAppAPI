import { renderOrderList } from "./renderOrderList.js"
import { getOrderList } from "./fetchOrder.js"
import { formatOrderData } from "./formatOrderData.js"

export async function addFoodToOrder(foodToOrder) {
    const orderPayLoad = formatOrderData(foodToOrder)
    try {
        const response = await fetch("http://localhost:8080/api/orderItem", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(orderPayLoad)
        })
        if (response.ok) {
            // Refresh food list each time when new food is added
            const updatedOrderList = await getOrderList()
            renderOrderList(updatedOrderList)
        } else {
            console.error(`Failed to add food to order: ${response.status}`)
        }
    } catch (error) {
        console.error(`Error: ${error}`)
    }
}