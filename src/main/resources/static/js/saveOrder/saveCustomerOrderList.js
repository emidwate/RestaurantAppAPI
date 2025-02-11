export async function saveCustomerOrderList(customerOrder, status) {
    try {
        const response = await fetch(`/api/order?status=${status}`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(customerOrder)
        })
        if(!response.ok) {
            const data = await response.json()
            console.error(`Failed to save order: ${response.status} ${response.statusText}`)
            console.log(data.message)
        } else {
            console.log("Order saved successfully!")
        }
    } catch (error) {
        console.error(`Error while saving customer order to database: ${error}`)
    }
}