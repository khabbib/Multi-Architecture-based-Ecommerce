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
	<h1>Dashboard</h1>
	<!-- Dashboard content -->
	<button on:click={handleLogout}>Logout</button>
	{#if users.length > 0}
		<p>Online users:</p>
		{#each users as user}
			<p>{user.email}</p>
			<p>{user.name}</p>
			<p>{user.role}</p>
		{/each}
	{/if}
	
</main>
