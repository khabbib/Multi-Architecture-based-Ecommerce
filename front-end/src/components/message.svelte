<script>
	import { onMount } from 'svelte';

	export let error;

	onMount(() => {
		setTimeout(() => {
			error = null; // Clear the error after 10 seconds
		}, 2000);
	});
</script>

{#if error !== null}
	<h1 style="color: {error.status === 'success' ? 'green' : 'red'};">{error.error}</h1>
{/if}

<style>
	h1 {
		text-align: center;
		height: 2rem;
		margin-top: -3rem;
	}
</style>
