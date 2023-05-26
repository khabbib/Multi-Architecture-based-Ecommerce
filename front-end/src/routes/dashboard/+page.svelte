<script>
	import { onMount } from 'svelte';
	import { checkAuthInDashboardPage, getOnlineUsers, handleLogout } from '../../events/util';

	let users = [];
	onMount(async () => {
		checkAuthInDashboardPage();


		users = await getOnlineUsers();
  		console.log('Online Users:', users);
	});

</script>

<main>
	<!-- Dashboard content -->
	<div class="bg-cyan-100 p-10">

		<h1 class="font-bold text-xl">Dashboard</h1>

		<button on:click={handleLogout} class="bg-red-100 shadow m-1 p-2 rounded">Logout</button>

		{#if users.length > 0}
			<p>Online users:</p>
			{#each users as user}
				<p>{user.email}</p>
				<p>{user.name}</p>
				<p>{user.role}</p>
			{/each}
		{/if}

		<div class="grid grid-cols-[200px_minmax(900px,_1fr)_100px]">
			<div class="bg-teal-300 p-4 w-48 rounded grid-cols-1">
				<div class="">
					<a class="bg-teal-200 p-2 rounded" href="#">Overview</a>
				</div>

				<br />

				<div class="">
					<a class="bg-teal-200 p-2 rounded" href="#">Orders</a>
				</div>

				<br />

				<div class="">
					<a class="bg-teal-200 p-2 rounded" href="#">Users</a>
				</div>

				<br />

				<div class="">
					<a class="bg-teal-200 p-2 rounded" href="#">Inventory</a>
				</div>

				<br />

				<div class="">
					<a class="bg-teal-200 p-2 rounded" href="#">Settings</a>
				</div>
			</div>

			<div class="bg-teal-50 p-4 rounded w-auto h-96">
				<h1>Welcome to dashboard!</h1>
			</div>
		</div>
	</div>
	
</main>
