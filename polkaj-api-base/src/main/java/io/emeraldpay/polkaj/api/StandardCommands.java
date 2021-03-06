package io.emeraldpay.polkaj.api;

import io.emeraldpay.polkaj.json.*;
import io.emeraldpay.polkaj.types.Address;
import io.emeraldpay.polkaj.types.ByteData;
import io.emeraldpay.polkaj.types.Hash256;

import java.util.ArrayList;
import java.util.List;

/**
 * Standard/common Polkadot Commands
 */
public class StandardCommands {

    private static final StandardCommands instance = new StandardCommands();

    public static StandardCommands getInstance() {
        return instance;
    }

    /**
     * Request for a block by its hash
     * @param hash hash of the block
     * @return command
     */
    public RpcCall<BlockResponseJson> getBlock(Hash256 hash) {
        return RpcCall.create(BlockResponseJson.class, PolkadotMethod.CHAIN_GET_BLOCK, hash);
    }

    public RpcCall<Hash256> getBlockHash() {
        return RpcCall.create(Hash256.class, PolkadotMethod.CHAIN_GET_BLOCK_HASH);
    }

    public RpcCall<Hash256> getBlockHash(long at) {
        return RpcCall.create(Hash256.class, PolkadotMethod.CHAIN_GET_BLOCK_HASH, at);
    }

    /**
     * Request for the hash of the current finalized head
     * @return command
     */
    public RpcCall<Hash256> getFinalizedHead() {
        return RpcCall.create(Hash256.class, PolkadotMethod.CHAIN_GET_FINALIZED_HEAD);
    }

    /**
     * Request the runtime version of the blockchain
     * @return command
     */
    public RpcCall<RuntimeVersionJson> getRuntimeVersion() {
        return RpcCall.create(RuntimeVersionJson.class, PolkadotMethod.STATE_GET_RUNTIME_VERSION);
    }

    /**
     * Request a list of available RPC methods
     * @return command
     */
    public RpcCall<MethodsJson> methods() {
        return RpcCall.create(MethodsJson.class, PolkadotMethod.RPC_METHODS);
    }

    /**
     * Request name of the current chain
     * @return command
     */
    public RpcCall<String> systemChain() {
        return RpcCall.create(String.class, PolkadotMethod.SYSTEM_CHAIN);
    }

    /**
     * Request health status of the current node
     * @return command
     */
    public RpcCall<SystemHealthJson> systemHealth() {
        return RpcCall.create(SystemHealthJson.class, PolkadotMethod.SYSTEM_HEALTH);
    }

    /**
     * Request name of the current node
     * @return command
     */
    public RpcCall<String> systemName() {
        return RpcCall.create(String.class, PolkadotMethod.SYSTEM_NAME);
    }

    /**
     * Request roles of the current node
     * @return command
     */
    public RpcCall<List<String>> systemNodeRoles() {
        return RpcCall.create(String.class, PolkadotMethod.SYSTEM_NODE_ROLES).expectList();
    }

    /**
     * Request peer list connected to the current node
     * @return command
     */
    public RpcCall<List<PeerJson>> systemPeers() {
        return RpcCall.create(PeerJson.class, PolkadotMethod.SYSTEM_PEERS).expectList();
    }

    /**
     * Request version of the current node
     * @return command
     */
    public RpcCall<String> systemVersion() {
        return RpcCall.create(String.class, PolkadotMethod.SYSTEM_VERSION);
    }

    /**
     * Request runtime metadata of the current node
     * @return command
     */
    public RpcCall<ByteData> stateMetadata() {
        return RpcCall.create(ByteData.class, PolkadotMethod.STATE_GET_METADATA);
    }

    /**
     * Request data from storage
     * @param key key (depending on the storage)
     * @return command
     */
    public RpcCall<ByteData> stateGetStorage(ByteData key) {
        return RpcCall.create(ByteData.class, PolkadotMethod.STATE_GET_STORAGE, key.toString());
    }

    /**
     * @deprecated Use RpcCall.create(Hash256.class, PolkadotMethod.STATE_GET_STORAGE_HASH, ...)
     * @param key key
     * @param at block (optional)
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<Hash256> stateGetStorageHash(ByteData key, Hash256 at) {
        List<Object> params = at == null ? List.of(key) : List.of(key, at);
        return RpcCall.create(Hash256.class, PolkadotMethod.STATE_GET_STORAGE_HASH, params);
    }

    /**
     * @deprecated Use RpcCall.create(Hash256.class, PolkadotMethod.STATE_GET_STORAGE_SIZE, ...)
     * @param key key
     * @param at block (optional)
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<Long> stateGetStorageSize(ByteData key, Hash256 at) {
        List<Object> params = at == null ? List.of(key) : List.of(key, at);
        return RpcCall.create(Long.class, PolkadotMethod.STATE_GET_STORAGE_SIZE, params);
    }

    /**
     * @deprecated Use RpcCall.create(ByteData.class, PolkadotMethod.STATE_CALL, ...)
     * @param method method name
     * @param data call data
     * @param at block (optional)
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<ByteData> stateCall(String method, ByteData data, Hash256 at) {
        List<Object> params = at == null ? List.of(method, data) : List.of(method, data, at);
        return RpcCall.create(ByteData.class, PolkadotMethod.STATE_CALL, params);
    }

    /**
     * @deprecated Use RpcCall.create(ByteData.class, "state_getChildKeys", ...).expectList()
     * @param childStorageKey child key
     * @param childDefinition child definition
     * @param childType type
     * @param key key
     * @param at block (optional)
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<List<ByteData>> stateGetChildKeys(ByteData childStorageKey, ByteData childDefinition, long childType, ByteData key, Hash256 at) {
        List<Object> params = new ArrayList<>(List.of(childStorageKey, childDefinition, childType, key));
        if (at != null) {
            params.add(at);
        }
        return RpcCall.create(ByteData.class, "state_getChildKeys", params).expectList();
    }

    /**
     * @deprecated Use RpcCall.create(ByteData.class, "state_getChildStorage", ...)
     * @param childStorageKey child key
     * @param childDefinition child definition
     * @param childType type
     * @param key key
     * @param at block (optional)
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<ByteData> stateGetStorageData(ByteData childStorageKey, ByteData childDefinition, long childType, ByteData key, Hash256 at) {
        List<Object> params = new ArrayList<>(List.of(childStorageKey, childDefinition, childType, key));
        if (at != null) {
            params.add(at);
        }
        return RpcCall.create(ByteData.class, "state_getChildStorage", params);
    }

    /**
     * @deprecated Use RpcCall.create(Hash256.class, "state_getChildStorageHash", ...)
     * @param childStorageKey child key
     * @param childDefinition child definition
     * @param childType type
     * @param key key
     * @param at block (optional)
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<Hash256> stateGetChildStorageHash(ByteData childStorageKey, ByteData childDefinition, long childType, ByteData key, Hash256 at) {
        List<Object> params = new ArrayList<>(List.of(childStorageKey, childDefinition, childType, key));
        if (at != null) {
            params.add(at);
        }
        return RpcCall.create(Hash256.class, "state_getChildStorageHash", params);
    }

    /**
     * @deprecated RpcCall.create(Long.class, "state_getChildStorageSize", ...)
     * @param childStorageKey child key
     * @param childDefinition child definition
     * @param childType type
     * @param key key
     * @param at block (optional)
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<Long> stateGetChildStorageSize(ByteData childStorageKey, ByteData childDefinition, long childType, ByteData key, Hash256 at) {
        List<Object> params = new ArrayList<>(List.of(childStorageKey, childDefinition, childType, key));
        if (at != null) {
            params.add(at);
        }
        return RpcCall.create(Long.class, "state_getChildStorageSize", params);
    }

    /**
     * @deprecated Use RpcCall.create(ByteData.class, PolkadotMethod.STATE_KEYS_PAGED, ...).expectList()
     * @param key key
     * @param count count
     * @param startKey start key (optional)
     * @param at block (optional)
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<List<ByteData>> stateGetKeys(ByteData key, int count, ByteData startKey, Hash256 at) {
        List<Object> params = new ArrayList<>(List.of(key, count));
        if (startKey != null) {
            params.add(startKey);
        }
        if (at != null) {
            params.add(at);
        }
        return RpcCall.create(ByteData.class, PolkadotMethod.STATE_KEYS_PAGED, params).expectList();
    }

    public RpcCall<ReadProofJson> stateGetReadProof(List<ByteData> keys, Hash256 at) {
        List<Object> params = new ArrayList<>(List.of(keys));
        if (at != null) {
            params.add(at);
        }
        return RpcCall.create(ReadProofJson.class, PolkadotMethod.STATE_GET_READ_PROOF, params);
    }

    /**
     * @deprecated Use RpcCall.create(ByteData.class, PolkadotMethod.STATE_QUERY_STORAGE, ...).expectList()
     * @param keys keys
     * @param fromBlock from block
     * @param toBlock to block
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<List<ByteData>> stateQueryStorage(List<ByteData> keys, Hash256 fromBlock, Hash256 toBlock) {
        List<Object> params = new ArrayList<>(List.of(keys, fromBlock));
        if (toBlock != null) {
            params.add(toBlock);
        }
        return RpcCall.create(ByteData.class, PolkadotMethod.STATE_QUERY_STORAGE, params).expectList();
    }

    /**
     * @deprecated Use RpcCall.create(ByteData.class, PolkadotMethod.STATE_QUERY_STORAGE_AT, ...).expectList()
     * @param keys keys
     * @param at block
     * @return command
     */
    @Deprecated(forRemoval = true)
    public RpcCall<List<ByteData>> stateQueryStorageAt(List<ByteData> keys, Hash256 at) {
        List<Object> params = new ArrayList<>(List.of(keys));
        if (at != null) {
            params.add(at);
        }
        return RpcCall.create(ByteData.class, PolkadotMethod.STATE_QUERY_STORAGE_AT, params).expectList();
    }

    /**
     * Request data from storage
     * @param request key (depending on the storage)
     * @return command
     */
    public RpcCall<ByteData> stateGetStorage(byte[] request) {
        return stateGetStorage(new ByteData(request));
    }

    public RpcCall<ContractExecResultJson> contractsCall(ContractCallRequestJson request) {
        return RpcCall.create(ContractExecResultJson.class, "contracts_call", request);
    }

    public RpcCall<ContractExecResultJson> contractsCall(ContractCallRequestJson request, Hash256 at) {
        if (at == null) {
            return contractsCall(request);
        }
        return RpcCall.create(ContractExecResultJson.class, "contracts_call", request, at);
    }

    /**
     *
     * @param address contract address
     * @param key key
     * @return comman
     */
    public RpcCall<ByteData> contractsGetStorage(Address address, Hash256 key) {
        return RpcCall.create(ByteData.class, "contracts_getStorage", address, key);
    }

    /**
     *
     * @param address contract address
     * @param key key
     * @param at block hash
     * @return command
     */
    public RpcCall<ByteData> contractsGetStorage(Address address, Hash256 key, Hash256 at) {
        if (at == null) {
            return contractsGetStorage(address, key);
        }
        return RpcCall.create(ByteData.class, "contracts_getStorage", address, key, at);
    }

    /**
     *
     * @param address contract address
     * @return command
     */
    public RpcCall<Long> contractsRentProjection(Address address) {
        return RpcCall.create(Long.class, "contracts_rentProjection", address);
    }

    /**
     *
     * @param address contract address
     * @param at block hash
     * @return command
     */
    public RpcCall<Long> contractsRentProjection(Address address, Hash256 at) {
        if (at == null) {
            return contractsRentProjection(address);
        }
        return RpcCall.create(Long.class, "contracts_rentProjection", address, at);
    }

}
