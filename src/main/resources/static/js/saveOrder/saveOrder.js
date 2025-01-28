import { getOrderList } from "../customerOrder/fetchOrder.js"
import { saveCustomerOrderList } from "./saveCustomerOrderList.js"

const saveOrderBtn = document.getElementById("save-order")

saveOrderBtn.addEventListener("click", async () => {
    const orderStatusOption = document.getElementById("order-status").value
    const response = await getOrderList()
    saveCustomerOrderList(response, orderStatusOption)
})