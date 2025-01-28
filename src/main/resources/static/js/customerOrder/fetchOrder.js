export async function getOrderList() {
    try {
        const response = await fetch("http://localhost:8080/api/orderList")
        if (!response.ok) {
            console.error(`Failed to fetch list: ${response.status} ${response.statusText}`)
        }
        const data = await response.json()
        return data
    } catch (error) {
        console.error(`Error: ${error}`)
    }
}