/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.picketlink.test.idm.other.shane.model.scenario1.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.picketlink.idm.jpa.annotations.OwnerReference;
import org.picketlink.idm.jpa.annotations.entity.IdentityManaged;
import org.picketlink.idm.jpa.annotations.entity.MappedAttribute;
import org.picketlink.test.idm.other.shane.model.scenario1.User;

/**
 * This entity bean stores the user attribute values that are mapped directly to the User class 
 *
 * @author Shane Bryzak
 *
 */
@Entity
@IdentityManaged (User.class)
@MappedAttribute("employeeContract")
public class EmployeeContract implements Serializable {
    private static final long serialVersionUID = -2360572753933756991L;

    @Id @OneToOne @OwnerReference private IdentityObject identity;
    private Date signedDate;
    @Column (length = 100000) private byte[] document;

    public IdentityObject getIdentity() {
        return identity;
    }

    public void setIdentity(IdentityObject identity) {
        this.identity = identity;
    }

    public Date getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Date signedDate) {
        this.signedDate = signedDate;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

}
