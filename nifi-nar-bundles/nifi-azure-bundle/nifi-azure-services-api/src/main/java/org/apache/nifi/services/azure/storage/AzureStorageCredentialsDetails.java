/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.services.azure.storage;

import com.azure.storage.common.StorageSharedKeyCredential;

public class AzureStorageCredentialsDetails {

    private final String storageAccountName;
    private final String storageSuffix;

    private final String sasToken;
    private final StorageSharedKeyCredential storageSharedKeyCredential;

    public enum CredentialType {
        // using SAS token for authentication
        SAS_TOKEN,
        // using Storage Account key to authenticate with Storage Account.
        STORAGE_ACCOUNT_KEY
    }

    private final CredentialType credentialType;

    public AzureStorageCredentialsDetails(String storageAccountName, String storageSuffix, String sasToken) {
        this.storageAccountName = storageAccountName;
        this.storageSuffix = storageSuffix;

        this.sasToken = sasToken;
        this.storageSharedKeyCredential = null;

        this.credentialType = CredentialType.SAS_TOKEN;
    }

    public AzureStorageCredentialsDetails(String storageAccountName, String storageSuffix, StorageSharedKeyCredential storageSharedKeyCredential) {
        this.storageAccountName = storageAccountName;
        this.storageSuffix = storageSuffix;

        this.storageSharedKeyCredential = storageSharedKeyCredential;
        this.sasToken = null;

        this.credentialType = CredentialType.STORAGE_ACCOUNT_KEY;
    }

    public String getStorageAccountName() {
        return storageAccountName;
    }

    public String getStorageSuffix() {
        return storageSuffix;
    }

    public String getSasToken() {
        return sasToken;
    }

    public StorageSharedKeyCredential getStorageSharedKeyCredential() {
        return storageSharedKeyCredential;
    }

    public CredentialType getCredentialType() {
        return credentialType;
    }
}
