// Create Customer
async function createCustomer() {
    const customer = {
        name: document.getElementById("name").value,
        age: document.getElementById("age").value,
        address: document.getElementById("address").value,
        emailId: document.getElementById("emailId").value,
        phoneNumber: document.getElementById("phoneNumber").value
    };

    const response = await fetch("/customer", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(customer)
    });

    const data = await response.json();
    alert("Customer Created Successfully!");
    console.log(data);
}

// Fetch All Customers
async function fetchAllCustomers() {
    const response = await fetch("/all-customers");
    const customers = await response.json();

    const list = document.getElementById("customerList");
    list.innerHTML = "";

    customers.forEach(c => {
        const div = document.createElement("div");
        div.className = "customer-item";
        div.innerHTML = `
            <strong>ID:</strong> ${c.id} <br>
            <strong>Name:</strong> ${c.name} <br>
            <strong>Age:</strong> ${c.age} <br>
            <strong>Address:</strong> ${c.address} <br>
            <strong>Email:</strong> ${c.emailId} <br>
            <strong>Phone:</strong> ${c.phoneNumber}
        `;
        list.appendChild(div);
    });
}

// Fetch Single Customer
async function fetchCustomer() {
    const id = document.getElementById("fetchId").value;

    const response = await fetch(`/get/customer/${id}`);
    const customer = await response.json();

    document.getElementById("singleCustomer").textContent =
        JSON.stringify(customer, null, 2);
}

// Update Customer
async function updateCustomer() {
    const id = document.getElementById("updateId").value;

    const updatedCustomer = {
        name: document.getElementById("updateName").value,
        age: document.getElementById("updateAge").value,
        address: document.getElementById("updateAddress").value,
        emailId: document.getElementById("updateEmailId").value,
        phoneNumber: document.getElementById("updatePhoneNumber").value
    };

    const response = await fetch(`/update/customer/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(updatedCustomer)
    });

    const data = await response.json();
    alert("Customer Updated Successfully!");
    console.log(data);
}

// Delete Customer
async function deleteCustomer() {
    const id = document.getElementById("deleteId").value;

    const response = await fetch(`/delete/customer/${id}`, {
        method: "DELETE"
    });

    const data = await response.json();
    alert("Customer Deleted Successfully!");
    console.log(data);
}