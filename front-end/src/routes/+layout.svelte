<script>
	import '../app.css';
	import Header from '../components/header.svelte';
	import Footer from '../components/footer.svelte';
	import { onMount } from 'svelte';
</script>

<div class="layout">
	<Header />
	<main>
		<slot />
	</main>
	<Footer />
</div>

<style>
	.layout {
		height: 100%;
		max-inline-size: 1440px;
		display: grid;
		grid-template-rows: auto 1fr auto;
		margin-inline: auto;
		padding-inline: 5.5%;
	}

	main {
		height: 80vh;
		overflow: scroll;
	}

	@media (min-width: 1440px) {
		.layout {
			padding-inline: 0;
		}
	}
</style>
