/* Copyright CNRS-CREATIS
 *
 * Rafael Silva
 * rafael.silva@creatis.insa-lyon.fr
 * http://www.rafaelsilva.com
 *
 * This software is a grid-enabled data-driven workflow manager and editor.
 *
 * This software is governed by the CeCILL  license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */
package fr.insalyon.creatis.grida.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Silva
 */
public class GridData {

    public static enum Type {

        Folder, File
    };
    private String name;
    private Type type;
    private long length;
    private String modificationDate;
    private List<String> replicas;
    private String permissions;
    private String comment;

    public GridData(String name, Type type, String permissions) {
        this(name, type, 0, "", "", permissions, "");
    }

    public GridData(String name, Type type, long length, String modificationDate, 
            String replicasString, String permission){
        this(name,type,length,modificationDate,replicasString,permission,"");
    } 
    
    public GridData(String name, Type type, long length, String modificationDate, 
            String replicasString, String permissions, String comment) {
        
        this.name = name;
        this.type = type;
        this.length = length;
        this.modificationDate = modificationDate;
        this.comment = comment;
        if (permissions.contains(",")) {
            this.permissions = permissions.split(",")[2];
        } else {
            this.permissions = permissions;
        }

        replicas = new ArrayList<String>();
        String[] reps = replicasString.split(",");
        for (int i = 2; i < reps.length - 1; i++) {
             replicas.add(reps[i]);
        }
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public long getLength() {
        return length;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public String getPermissions() {
        return permissions;
    }

    public List<String> getReplicas() {
        return replicas;
    }
    
    public String getComment(){
        return comment;
    }
}
