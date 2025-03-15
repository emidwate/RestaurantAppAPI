import { renderOrderList } from "./renderOrderList.js"

export async function truncateOrderTable() {
    try {
        const response = await fetch("/api/order/truncate", {
            method: "DELETE"
        })
        if (!response.ok) {
            console.error(`Failed to truncate order table: ${response.status} ${response.statusText}`)
        }
        renderOrderList([])
        console.log("Table has been truncated successfully!")
    } catch (error) {
        console.error(`Error: ${error}`)
    }
}