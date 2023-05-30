<script>
	import { onMount } from 'svelte';
	import { checkAuthInDashboardPage, getOnlineUsers, handleLogout } from '../../events/util';
	import { preInitializePage } from '../../events/navigator';
	import Message from '../../components/message.svelte';

	let users = [];
	let error = null;
	onMount(async () => {
		error = preInitializePage();
		checkAuthInDashboardPage();
		users = await getOnlineUsers();
		console.log('Online Users:', users);
	});

	// ********** NAVIGATION DASHBOARD ********** //

	// Here State-Machite pattern is used!
	let state = 'overview'; // default
	let border1 = 'solid'; // default
	let border2 = '';
	let border3 = '';
	let border4 = '';
	let border5 = '';
	let border6 = '';

	// functions to switch menu and display current status with border.
	function navOverview() {
		state = 'overview';
		border1 = 'solid';
		border2 = '';
		border3 = '';
		border4 = '';
		border5 = '';
		border6 = '';
	}
	function navAddProd() {
		state = 'addprod';
		border1 = '';
		border2 = 'solid';
		border3 = '';
		border4 = '';
		border5 = '';
		border6 = '';
	}
	function navOrders() {
		state = 'orders';
		border1 = '';
		border2 = '';
		border3 = 'solid';
		border4 = '';
		border5 = '';
		border6 = '';
	}
	function navOrderHistory() {
		state = 'orderhistory';
		border1 = '';
		border2 = '';
		border3 = '';
		border4 = 'solid';
		border5 = '';
		border6 = '';
	}
	function navChart() {
		state = 'chart';
		border1 = '';
		border2 = '';
		border3 = '';
		border4 = '';
		border5 = 'solid';
		border6 = '';
	}
	function navSettings() {
		state = 'settings';
		border1 = '';
		border2 = '';
		border3 = '';
		border4 = '';
		border5 = '';
		border6 = 'solid';
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
								style="border-bottom: {border4}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Order History</button
							>
							<button
								on:click={navChart}
								style="border-bottom: {border5}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Chart</button
							>
							<button
								on:click={navSettings}
								style="border-bottom: {border6}"
								class="bg-teal-200 p-2 rounded hover:opacity-70">Settings</button
							>
							<button on:click={handleLogout} class="bg-red-300 p-2 rounded">Logout</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="bg-teal-50 p-4 rounded w-auto h-[38.2rem]">
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
						<p>Email: {user.email}</p>
						<p>Name: {user.name}</p>
						<p>Role: {user.role}</p>
					{/each}
				{/if}
			{:else if state == 'addprod'}
				<p>Add product</p>
			{:else if state == 'orders'}
				<p>orders page!</p>
			{:else if state == 'orderhistory'}
				<p>orderhistory page!</p>
			{:else if state == 'chart'}
				<p>chart page!</p>
			{:else if state == 'settings'}
				<p>setting page!</p>
			{/if}
		</div>
	</div>
</main>
