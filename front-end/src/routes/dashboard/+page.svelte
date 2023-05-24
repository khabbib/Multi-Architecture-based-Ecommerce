<script>
	import { onMount } from 'svelte';
	import { navigate } from '../../events/navigator';

	onMount(async () => {
		// Check if user is authenticated
		const isAuthenticated = await fetch('http://localhost:8080/auth/check', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ token: localStorage.getItem('sessionToken') }),
		})
			.then((res) => {
				console.log('check Response: ', res);
				if(res.status === 200){
					console.log("User is still logged in")
				}
				else{
					navigate('login');
				}
			})
			.catch((err) => {
				console.error('Error: ', err);
			});
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
