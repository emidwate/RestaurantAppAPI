import { renderOrderList } from "./renderOrderList.js"
import { getOrderList } from "./fetchOrder.js"

export async function removeOrderItem(orderId) {
    try {
        const response = await fetch(`http://localhost:8080/api/orderItem/${orderId}`, {
            method: "DELETE"
        })
        if (response.ok) {
            // Refresh food list each time when new food is added
            const updatedOrderList = await getOrderList()
            renderOrderList(updatedOrderList)
        } else {
            console.error(`Failed to remove food: ${response.status}`)
        }
    } catch (error) {
        console.error(`Error: ${error}`)
    }
}