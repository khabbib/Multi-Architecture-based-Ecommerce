<script>
	import Table from '../../components/dashboard/table.svelte';
	import Miniheader from '../../components/dashboard/miniheader.svelte';
	import Dashheader from '../../components/dashboard/dashheader.svelte';
	import Model from '../../components/dashboard/model.svelte';
	import Notification from '../../components/dashboard/notification.svelte';
    import Confirm from '../../components/confirm.svelte';
</script>

<div class="components">
	<Confirm data={'ic'} />
    <Notification data={'ic'} />
	<Model data={'ic'} />
	<Dashheader data={'ic'} />
	<Miniheader data={'ic'} />

	<Table data={'ic'} />
</div>

<style>
	.components {
		padding: 4rem 0;
		border: 1px solid #e2e8f0;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
</style>
