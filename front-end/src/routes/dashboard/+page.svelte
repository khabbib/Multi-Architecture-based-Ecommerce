<script>
	import { onMount } from 'svelte';
	import { checkSessionExpiration } from '../../events/auth-service';
	onMount(async () => {
		if (typeof window !== 'undefined') {
			if (window.location.href.includes('/dashboard')) {
				console.log('Checking session expiration...');
				setInterval(() => {
					checkSessionExpiration();
				}, 2000);
			}
		}
	});
</script>

<h1>You are logged in!</h1>
