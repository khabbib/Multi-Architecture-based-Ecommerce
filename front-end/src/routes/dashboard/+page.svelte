<script>
	import { onMount } from 'svelte';
	import { navigate } from '../../events/navigator';

	onMount(() => {
		// Check if user is authenticated
		const token = localStorage.getItem('sessionToken'); // Retrieve the token from cookie or local storage
		console.log('Dashboard: ', token);
		if (!token) {
			//navigate('login'); // Redirect to login if token is not found
		} else {
			const tokenExpiration = localStorage.getItem('sessionTokenExpiration');
			console.log('Dashboard: ', tokenExpiration);
			const expirationTime = new Date(tokenExpiration).getTime();
			const currentTime = new Date().getTime();
			if (currentTime > expirationTime) {
				// Token has expired, clear the token and redirect to login
				localStorage.removeItem('sessionToken');
				localStorage.removeItem('sessionTokenExpiration');
				// navigate('login');
			}
		}
	});

	async function handleLogout() {
		try {
			localStorage.removeItem('sessionToken'); // Clear the token from cookie or local storage
			navigate('login'); // Redirect to the login page
		} catch (error) {
			console.error('Logout failed', error);
			// Handle logout error, display error message to the user, etc.
		}
	}
</script>

<main>
	<h1>Dashboard</h1>
	<!-- Dashboard content -->
	<button on:click={handleLogout}>Logout</button>
</main>
