<script>
	import { onMount } from 'svelte';
	import {
		checkAuthInDashboardPage,
		getOnlineUsers,
		handleLogout,
		getOrderHistory
	} from '../../events/util';
	import { preInitializePage } from '../../events/navigator';
	import Message from '../../components/message.svelte';
	import Product from '../product/+page.svelte';

	let users = [];
	let error = null;
	let orderHistory = [];

	onMount(async () => {
		error = preInitializePage();
		checkAuthInDashboardPage();
		users = await getOnlineUsers();
		console.log('Online Users:', users);
	});

	async function setOrderHistory() {
		orderHistory = await getOrderHistory();
	}

	// ********** NAVIGATION DASHBOARD ********** //

	// Here State-Machite pattern is used!
	let state = 'overview'; // default
	let border1 = 'solid'; // default
	let border2 = '';
	let border3 = '';
	let border4 = '';
	let border5 = '';
	let border6 = '';
	let border7 = '';

	// functions to switch menu and display current status with border.
	function navOverview() {
		state = 'overview';
		border1 = 'solid';
		border2 = '';
		border3 = '';
		border4 = '';
		border5 = '';
		border6 = '';
		border7 = '';
	}
	function navAddProd() {
		state = 'addprod';
		border1 = '';
		border2 = 'solid';
		border3 = '';
		border4 = '';
		border5 = '';
		border6 = '';
		border7 = '';
	}
	function navOrders() {
		state = 'orders';
		border1 = '';
		border2 = '';
		border3 = 'solid';
		border4 = '';
		border5 = '';
		border6 = '';
		border7 = '';
	}
	function navOrderHistory() {
		state = 'orderhistory';
		border1 = '';
		border2 = '';
		border3 = '';
		border4 = 'solid';
		border5 = '';
		border6 = '';
		border7 = '';
	}
	function navChart() {
		state = 'chart';
		border1 = '';
		border2 = '';
		border3 = '';
		border4 = '';
		border5 = 'solid';
		border6 = '';
		border7 = '';
	}
	function navSettings() {
		state = 'settings';
		border1 = '';
		border2 = '';
		border3 = '';
		border4 = '';
		border5 = '';
		border6 = 'solid';
		border7 = '';
	}
	function navProducts() {
		state = 'product';
		border1 = '';
		border2 = '';
		border3 = '';
		border4 = '';
		border5 = '';
		border6 = '';
		border7 = 'solid';
	}
</script>

<main>
	<!-- Dashboard content -->
	<div class="bg-cyan-100 p-10">
		<Message {error} />

		<div class="bg-teal-300 p- rounded grid-cols-1">
			<div class="grid grid-cols-[200px_minmax(400px,_1fr)_50px]">
				<div class="m-4 w-24">
					<h1 class="font-bold text-xl">Dashboard</h1>
				</div>
				<div class="m-4">
					<div class="items-center justify-between px-4 py-2">
						<div class="text-gray items-center justify-between gap-10">
							<button
								on:click={navOverview}
								style="border-bottom: {border1}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Overview</button
							>
							<button
								on:click={navAddProd}
								style="border-bottom: {border2}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Add product</button
							>
							<button
								on:click={navOrders}
								style="border-bottom: {border3}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Orders</button
							>
							<button
								on:click={navOrderHistory}
								on:click={setOrderHistory}
								style="border-bottom: {border4}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Order History</button
							>
							<button
								on:click={navChart}
								style="border-bottom: {border5}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Cart</button
							>
							<button
								on:click={navSettings}
								style="border-bottom: {border6}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Settings</button
							>
							<button
								on:click={navProducts}
								style="border-bottom: {border7}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Products</button
							>
							<button on:click={handleLogout} class="bg-red-300 p-2 rounded">Logout</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="bg-teal-50 p-4 rounded w-auto h-[80%]">
			{#if state == 'overview'}
				<h1 class="underline">Notifications:</h1>
				<p>You have 0 notifications!</p>

				<br />

				<h1 class="underline">Interests:</h1>
				<p>You have 0 registered interests!</p>

				<br />

				{#if users.length > 0}
					<h1 class="underline">Online users:</h1>
					{#each users as user}
						<div class="p-2 rounded border-2 border-gray-100 flex gap-2">
							<div
								class="rounded radius-2 border-2 border-gray-100 p-2 bg-teal-400"
								style="border-radius: 50%; width: 20px; height:20px;"
							/>
							<div>
								<div style="width: 90%; heigth:1px; background: gray;" />
								<p>Email: {user.email}</p>
								<p>Name: {user.name}</p>
								<p>Role: {user.role}</p>
							</div>
						</div>
					{/each}
				{/if}
			{:else if state == 'addprod'}
				<div class="p-2">
					<form action="">
						<input class="p-2" type="text" placeholder="Product Name" />
						<br /><br />
						<input class="p-2" type="text" placeholder="Product Price" />
						<br /><br />
						<input class="p-2" type="text" placeholder="Product Owner" />
						<br /><br />
						<button class="bg-green-200 p-2 rounded hover:opacity-70">Add product</button>
					</form>
				</div>
			{:else if state == 'orders'}
				<p>You have 0 orders.</p>
			{:else if state == 'orderhistory'}
				<h1 class="underline">Order History:</h1>
				{#if orderHistory.length > 0}
					{#each Object.values(orderHistory) as order}
						<div class="border-2 border-gray-400 p-2 mb-4">
							<p>Order ID: {order.orderId}</p>
							<p>Billing Address: {order.billingAddress}</p>
							<p>Customer ID: {order.customerId}</p>
							<p>Delivery Address: {order.deliveryAddress}</p>
							<p>Delivery Company: {order.deliveryCompany}</p>
							<p>Delivery Date: {order.deliveryDate}</p>
							<p>Delivery Status: {order.deliveryStatus}</p>
							<p>Payment Method: {order.paymentMethod}</p>
							<p>Shipping Address: {order.shippingAddress}</p>
							<p>Total Price (Tax): {order.totalPriceTax}</p>
							<p>Tracking Number: {order.trackingNumber}</p>
							<h2>Items:</h2>
							{#each order.items as item}
								<div class="border-2 border-gray-300 p-2 mb-2">
									<p>Product ID: {item.productId}</p>
									<p>Quantity: {item.quantity}</p>
									<p>Price: {item.price}</p>
								</div>
							{/each}
						</div>
					{/each}
				{:else}
					<p>No order history available.</p>
				{/if}
			{:else if state == 'chart'}
				<p>You have 0 items in cart.</p>
			{:else if state == 'settings'}
				<form action="">
					<input class="p-2" type="text" placeholder="First Name" value="Admin" disabled />
					<br /><br />
					<input class="p-2" type="text" placeholder="Last Name" value="Sample" disabled />
					<br /><br />
					<input class="p-2" type="text" placeholder="Email" value="admin@sample.com" disabled />
					<br /><br />
					<button class="bg-blue-200 p-2 rounded hover:opacity-70">Change profile</button>
				</form>
			{:else if state == 'product'}
				<Product />
			{/if}
		</div>
	</div>
</main>
